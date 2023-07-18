package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDAO;
import vo.Product;


@WebServlet("*.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 12L;
	
	ProductDAO productDAO = null;

	public void init(ServletConfig config) throws ServletException {
		productDAO = new ProductDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		String command = uri.substring(uri.lastIndexOf("/"));
		System.out.println(uri.lastIndexOf("/"));
		System.out.println("command:" + command);
		
		String nextPage = null;
		
		//세션 생성
		HttpSession session = request.getSession();
		
		if(command.equals("/productList.do")) {
			
			ArrayList<Product> productList = productDAO.getProductList();
			
			request.setAttribute("productList", productList);
			
			nextPage = "/product/productList.jsp";
				
		}else if(command.equals("/productView.do")) {
			String productId = request.getParameter("productId");
			Product product = productDAO.getProduct(productId);
			
			request.setAttribute("product", product);
			
			nextPage = "/product/productView.jsp";
		}else if(command.equals("/productForm.do")) { //상품 등록 페이지 요청
			
			nextPage = "/product/productForm.jsp";
		}else if(command.equals("/addProduct.do")) { //상품 등록 처리
			String realFolder = "C:/Users/kiyon/git/jspworks3/Market/src/main/webapp/upload";

			MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024,
					"utf-8", new DefaultFileRenamePolicy());
			
			//name 속성 가져오기(주의! multi를 사용)
			String productId = multi.getParameter("productId");
			String pname = multi.getParameter("pname");
			int unitPrice = Integer.parseInt(multi.getParameter("unitPrice"));
			String description = multi.getParameter("description");
			String category = multi.getParameter("category");
			String manufacturer = multi.getParameter("manufacturer");
			long unitsInStock = Long.parseLong(multi.getParameter("unitsInStock"));
			String condition = multi.getParameter("condition");
			
			//productImage 속성 가져옴
			Enumeration<String> files = multi.getFileNames();
			String name = "";
			String productImage = "";
			if(files.hasMoreElements()) {
				name = (String)files.nextElement();
				productImage = multi.getFilesystemName(name);
			}
			
			//Product 객체 생성
			Product newProduct = new Product();
			newProduct.setProductId(productId);
			newProduct.setPname(pname);
			newProduct.setUnitPrice(unitPrice);
			newProduct.setDescription(description);
			newProduct.setCategory(category);
			newProduct.setManufacturer(manufacturer);
			newProduct.setUnitsInStock(unitsInStock);
			newProduct.setCondition(condition);
			newProduct.setProductImage(productImage);
			
			productDAO.addProduct(newProduct);  //상품 등록 처리
		
			nextPage = "/productList.do";
		}else if(command.equals("/editProduct.do")) { //상품 편집 페이지
			ArrayList<Product> productList = productDAO.getProductList();
			
			String edit = request.getParameter("edit");
			
			request.setAttribute("productList", productList);
			request.setAttribute("edit", edit);
			
			nextPage = "/product/editProduct.jsp";
		}else if(command.equals("/addCart.do")) { //장바구니에 담기 처리	
			String id = request.getParameter("productId");
			
			//장바구니에 담기
			ArrayList<Product> goodsList = productDAO.getProductList();
			Product goods = new Product();
			
			for(int i=0; i<goodsList.size(); i++) {
				 goods = goodsList.get(i);
				 if(goods.getProductId().equals(id)) 
					 break;
			}
			
			//요청 아이디의 상품을 담은 장바구니를 초기화 함
			ArrayList<Product> list = (ArrayList<Product>)session.getAttribute("cartlist");
			if(list == null) {
				list = new ArrayList<>();
				session.setAttribute("cartlist", list);	 //장바구니 세션 발급
			}
			
			//요청 아이디의 상품이 장바구니에 담긴 목록이면 해당 상품의 수량을 증가시킴
			int cnt = 0;
			Product goodsQnt = new Product(); 
			
			for(int i=0; i<list.size(); i++){
				goodsQnt = list.get(i);
				if(goodsQnt.getProductId().equals(id)){
					cnt++;	//해당 아이디와 같은 품목이면 1증가
					int orderQuantity = goodsQnt.getQuantity() + 1;	//주문 수량 합계
					goodsQnt.setQuantity(orderQuantity);
				}
			}
			
			//요청 아이디의 상품이 장바구니에 담긴 목록이 아니면 해당 상품의 수량을 1로하고, 장바구니 목록에 추가함
			if(cnt == 0) {
				goods.setQuantity(1);
				list.add(goods);
			}
		}else if(command.equals("/cart.do")) { //장바구니 페이지
			//장바구니에 세션 가져오기(세션 유지)
			ArrayList<Product> cartList = (ArrayList<Product>)session.getAttribute("cartlist");
			if(cartList == null){
				cartList = new ArrayList<>();
			}
			
			Product product = null;
			int sum = 0;
			int total = 0;
			for(int i=0; i<cartList.size(); i++){
				product = cartList.get(i);	//장바구니에 들어있는 상품
				total = product.getUnitPrice() * product.getQuantity();	//품목별 합계 = 가격 x 수량					
				sum += total;   //총액
			}
			
			request.setAttribute("cartList", cartList);
			request.setAttribute("sum", sum);
			
			nextPage = "/product/cart.jsp";
		}
		
		//페이지 이동 - 포워딩
		if(command.equals("/addCart.do")) {
			String id = request.getParameter("productId");
			
			response.sendRedirect("/productView.do?productId=" + id);
		}
		else {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(nextPage);
			
			dispatcher.forward(request, response);
		}
	}
	
	public void destroy() {
		System.out.println("Servlet 해제...");
	}

}

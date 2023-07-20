<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String product = request.getParameter("product");  //상품 받기
	
	//상품을 저장할 장바구니(cart)에 세션을 가져와 유지.
	ArrayList<String> productList = (ArrayList)session.getAttribute("cartList");  
	
	if(productList == null){
		productList = new ArrayList<>();
		//"cartList" 이름으로 세션 발급
		session.setAttribute("cartList", productList); 
	}
	
	productList.add(product);  //장바구니에 상품 추가함

%>

<script>
	alert("<%=product  %>가(이) 추가되었습니다.");
	history.go(-1);
</script>
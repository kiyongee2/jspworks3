package product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService2 {
	
//	Map<String, Product> products = new HashMap<>();
	List<Product> productList = new ArrayList<>();
	
	public ProductService2() {
		//Product 객체 생성
		Product p1 = new Product("11", "Galaxy21", "삼성 전자", 1000000, "2023. 03. 16");
		Product p2 = new Product("12", "LG 그램", "LG 전자", 1400000, "2023. 04. 16");
		Product p3 = new Product("13", "iPhone", "Apple", 1200000, "2023. 05. 16");
		
		//Map에 저장
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
	}
	
	//전체 상품 목록 보기
	public List<Product> getProductList(){
		return productList;
	}
	
}

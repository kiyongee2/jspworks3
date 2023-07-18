package product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
	
	Map<String, Product> products = new HashMap<>();
	
	public ProductService() {
		//Product 객체 생성
		Product p1 = new Product("11", "Galaxy21", "삼성 전자", 
				1000000, "2023. 03. 16");
		Product p2 = new Product("12", "LG 그램", "LG 전자", 
				1400000, "2023. 04. 16");
		Product p3 = new Product("13", "iPhone", "Apple", 
				1200000, "2023. 05. 16");
		
		//Map에 저장
		products.put("11", p1);
		products.put("12", p2);
		products.put("13", p3);
	}
	
	//전체 상품 목록 보기
	public List<Product> getProductList(){
		return new ArrayList<>(products.values());
	}
	
	//제품 상세 내역
	public Product getProduct(String pid) {
		return products.get(pid);
	}
}

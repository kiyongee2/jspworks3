package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthenFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("AuthenFilter 초기화...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//필터를 사용한 한글 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		//필터를 사용하여 입력값이 없을 경우 오류 문자를 출력
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		
		if(username.equals("") || username == "") {
			out.print("입력된 값은 null입니다.");
			return;  //filter01_process로 넘기지 않고 종료함
		}
		
		chain.doFilter(request, response);  //필터 처리
	}

	@Override
	public void destroy() {
		System.out.println("AuthenFilter 해제...");
	}
}

package filter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Members 초기화...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		
		String clientAddr = request.getRemoteAddr();  //IP 주소
		System.out.printf("클라이언트 IP 주소: %s %n", clientAddr);  //콘솔에 출력
		
		long start = System.currentTimeMillis();
		System.out.println("접근한 URL 경로: " + getURLPath(request));
		System.out.println("요청 처리 시작 시각: " + getCurrentTime());
		
		chain.doFilter(request, response);
		
		long end = System.currentTimeMillis();
		System.out.println("요청 처리 종료 시각: " + getCurrentTime());
		System.out.println("요청 처리 소요 시간: " + (end-start) + "ms");
		System.out.println("=============================================");
	}

	private String getURLPath(ServletRequest request) {
		HttpServletRequest req;
		String currentPath="";
		String queryString="";
		
		if(request instanceof HttpServletRequest) {
			req = (HttpServletRequest) request;
			currentPath = req.getRequestURI();
			queryString = req.getQueryString();
			queryString = queryString == null ? "" : "?" + queryString;
		}
		
		return currentPath+queryString;
	}

	private String getCurrentTime() {
		//현재 날짜와 시간
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter datetime = 
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		return now.format(datetime);
	}

	@Override
	public void destroy() {
		System.out.println("Members 해제...");
	}
}

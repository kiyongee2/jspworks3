package filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFileFilter implements Filter{
	
	PrintWriter writer;  //출력 객체 생성
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String filename = filterConfig.getInitParameter("filename");
		
		if(filename == null) {
			throw new ServletException("로그 파일을 찾을 수 없습니다.");
		}
		
		try {
			writer = new PrintWriter(new FileWriter(filename, true), true);
		} catch (IOException e) {
			throw new ServletException("로그 파일을 열 수 없습니다.");
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		
		String clientAddr = request.getRemoteAddr();  //IP 주소
		writer.printf("클라이언트 IP 주소: %s %n", clientAddr);  //콘솔에 출력
		
		long start = System.currentTimeMillis();
		writer.println("접근한 URL 경로: " + getURLPath(request));
		writer.println("요청 처리 시작 시각: " + getCurrentTime());
		
		chain.doFilter(request, response);
		
		long end = System.currentTimeMillis();
		writer.println("요청 처리 종료 시각: " + getCurrentTime());
		writer.println("요청 처리 소요 시간: " + (end-start) + "ms");
		writer.println("=============================================");
	}
	
	@Override
	public void destroy() {
		writer.close();
	}

	//접근한 URL 경로 가져오기
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

	//현재 날짜와 시간 가져오기
	private String getCurrentTime() {
		
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter datetime = 
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		return now.format(datetime);
	}
}

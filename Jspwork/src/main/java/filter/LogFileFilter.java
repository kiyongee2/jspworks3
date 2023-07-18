package filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

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
		writer.printf("클라이언트 IP 주소: %s %n", clientAddr);  //웹 페이지 출력
		System.out.printf("클라이언트 IP 주소: %s %n", clientAddr);  //콘솔에 출력
		
		String contentType = response.getContentType();  //컨텐츠 유형
		writer.printf("문서의 컨텐츠 유형: %s %n", contentType);
		
		//현재 날짜와 시간
		writer.printf("현재 일시: %s %n", getCurrentTime());
		System.out.printf("현재 일시: %s %n", getCurrentTime());
		
		chain.doFilter(request, response);
	}

	private String getCurrentTime() {
		//현재 날짜와 시간
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter datetime = 
				DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		
		return now.format(datetime);
	}

	@Override
	public void destroy() {
		writer.close();
	}
}

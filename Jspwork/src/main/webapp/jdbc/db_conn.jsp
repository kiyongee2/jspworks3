<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jdbc 연동</title>
</head>
<body>
	<%
		String driverClass = "com.mysql.cj.jdbc.Driver";      //mysql 드라이버
		String url = "jdbc:mysql://localhost:3306/javaweb";   //db 경로 포트-1521
		String username = "jweb";                             //사용자 이름
		String password = "54321";
		
		Connection conn = null;
	
		try{
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, username, password);
			out.println("DB 연결 객체 생성: " + conn);
		}catch(Exception e){
			out.println(e.getMessage());
		}finally{
			if(conn != null)
				conn.close();
		}
	%>
</body>
</html>
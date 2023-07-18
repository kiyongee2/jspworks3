<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 생성</title>
</head>
<body>
	<%
		String driverClass = "com.mysql.cj.jdbc.Driver";      //mysql 드라이버
		String url = "jdbc:mysql://localhost:3306/javaweb";   //db 경로 포트-1521
		String username = "jweb";                             //사용자 이름
		String password = "54321";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, username, password);
			String sql = "insert into user values(102, 'today123', '투데이', '010-1234-1234')";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			out.println("회원 생성!!");
		}catch(Exception e){
			out.println(e.getMessage());
		}finally{
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		}
	%>
</body>
</html>
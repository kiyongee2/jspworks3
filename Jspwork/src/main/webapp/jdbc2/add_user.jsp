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
	<%@ include file="db_conn.jsp" %>
	<%
		PreparedStatement pstmt = null;
		
		try{
			String sql = "insert into user values(103, 'today123', '한강', '010-1234-1234')";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			out.println("회원 생성!!");
		}catch(Exception e){
			out.println(e.getMessage());
		}
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>functions 태그</title>
</head>
<body>
	<h3>문자열 검색</h3>
	<p>Hello, Java Server Pages! =>
			${fn:contains("Hello, Java Server Pages", "java")}
	<p>Hello, Java Server Pages! =>
			${fn:containsIgnoreCase("Hello, Java Server Pages", "java")}
			
	<h3>문자열 분리</h3>
	<p>Hello, Java Server Pages! =>
	<p><c:set var="text" value="${fn:split('Hello, Java Server Pages', ' ')}" />
	<p>text[0] = ${text[0]}
	
	<p><c:forEach var="i" begin="0" end="${fn:length(text)-1}">
		${text[i]}
	</c:forEach>
	
	<h3>문자열 연결</h3>
	<p>${fn:join(text, '-') }
</body>
</html>
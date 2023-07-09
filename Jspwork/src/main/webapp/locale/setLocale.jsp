<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다국어 처리</title>
</head>
<body>
	<fmt:setLocale value="ko"/>
	<%= response.getLocale() %>
	
	<fmt:setLocale value="en"/>
	<%= response.getLocale() %>
</body>
</html>
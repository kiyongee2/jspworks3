<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<fmt:setLocale value="${param.language}"/>
	<fmt:bundle basename="bundle.message">
	<jsp:include page="../header.jsp" />
	<div id= "container">
		<section id="login">
		<div class="language">
			<a href="?language=ko">한국어</a> | <a href="?language=en">English</a>
		</div>
		<h2><fmt:message key="login.title" /></h2>
		<form action="/loginProcess.do" method="post">
            <fieldset>
                <ul>
                    <li>
                        <label><fmt:message key="login.id" /></label>
                        <input type="text" name="memberId">
                    </li>
                    <li>
                        <label><fmt:message key="login.passwd" /></label>
                        <input type="password" name="passwd">
                    </li>
                </ul>
            </fieldset>
            <div class="button">
                <input type="submit" value="<fmt:message key='login.button' />">
            </div>
          </form>
       </section>
	</div>
	</fmt:bundle>
</body>
</html>
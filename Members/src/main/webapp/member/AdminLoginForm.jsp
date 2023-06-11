<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div id= "container">
		<section id="login">
		<h2>관리자 로그인</h2>
		<form action="j_security_check" method="post">
			<%
				String error = request.getParameter("error");
				if(error != null){
					out.println("<div class='error'>");
					out.println("아이디와 비밀번호를 확인해 주세요");
					out.println("</div>");
				}
			%>
            <fieldset>
                <ul>
                    <li>
                        <label>아이디</label>
                        <input type="text" name="j_username" placeholder="ID" 
                        		required autofocus>
                    </li>
                    <li>
                        <label>비밀번호</label>
                        <input type="password" name="j_password"
                        		placeholder="PASSWORD" required>
                    </li>
                </ul>
            </fieldset>
            <div class="button">
                <input type="submit" value="로그인">
            </div>
          </form>
       </section>
	</div>
</body>
</html>
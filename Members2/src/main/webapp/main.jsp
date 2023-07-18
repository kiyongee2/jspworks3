<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강남 커뮤니티</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="container">
		<section id="main">
            <h1>안녕하세요~ 강남 Community입니다.</h1>
            <div class="img1">
                <img src="resources/images/gangnam.png" alt="배경 사진">
            </div>
            
            <div class="newBoard">
	            <h3><i class="fa-solid fa-pen"></i> 최근 게시글</h3>
	            <c:forEach var="board" items="${boardList }">
	           	<p>
	           		<a href="/boardView.do?bnum=${board.bnum}">${board.title} - 
	           			(<fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd HH:mm:ss" />, 
	           			글쓴이: ${board.memberId})</a>			
	           	</p>
	           </c:forEach>
           </div>
        </section>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
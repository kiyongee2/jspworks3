<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>댓글 수정 폼</title>
	<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div id="container">
		<section id="reply_update">
			<h2>댓글 수정</h2>
			<form action="/updateReply.do" method="post">
				<input type="hidden" name="bnum" value="${reply.bnum}">
				<input type="hidden" name="rno" value="${reply.rno}">
				<p>
					<textarea name="rcontent" rows="5" 
						cols="50">${reply.rcontent}</textarea>
				</p>
				<p><input type="text" name="replyer" 
						value="${reply.replyer}" readonly></p>
				<button type="submit">수정하기</button>
			</form>
		</section>
	</div>
</body>
</html>
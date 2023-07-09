<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판입니다.</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div id="container">
		<section id="boardlist">
			<h2>게시글 목록</h2>
			<table>
				<thead>
					<tr>
						<th>글번호</th><th>글제목</th><th>작성일</th><th>조회수</th><th>글쓴이</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${boardList}">
					<tr>
						<td><c:out value="${board.bnum}" /></td>
						<td>
							<a href="/boardView.do?bnum=<c:out value='${board.bnum}' />">
								<c:out value="${board.title}" /></a>
						</td>
						<%-- <td><c:out value="${board.regDate}" /></td> --%>
						<td><fmt:formatDate value="${board.regDate}" 
							pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td><c:out value="${board.hit}" /></td>
						<td><c:out value="${board.memberId}" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- 페이지 처리 영역 -->
			<div class="pagination">
				<%-- <p>총 게시글 수:${total}</p> --%>
				<!-- 시작 페이지가 1보다 작으면 시작 페이지로 설정 -->
			    <c:if test="${startPage > 1}">
					<a href="/boardList.do?pageNum=${startPage-1}">이전</a>
				</c:if>
			    <c:if test="${startPage <= 1}">
					<a href="">이전</a>
				</c:if>
				<c:forEach var="i" begin="1" end="${endPage}">
					<!-- 현재 페이지가 i와 같으면 활성화(굵게) -->
				    <c:if test="${currentPage == i}">
						<a href="/boardList.do?pageNum=${i}">
						<span class='page'>${i}</span>
						</a>
					</c:if>
				    <c:if test="${currentPage != i}">
						<a href="/boardList.do?pageNum=${i}">${i}</a>
					</c:if>
				</c:forEach>
				<!-- 마지막 페이지가 시작 페이지보다 작으면 마지막 페이지로 설정 -->
				<c:if test="${endPage > startPage}">
					<a href="/boardList.do?pageNum=${startPage+1}">다음</a>
				</c:if>
				<c:if test="${endPage <= startPage}">
					<a href="">다음</a>
				</c:if>
			</div>
			<!-- 페이지 영역 끝 -->
			<div class="btnWrite">
                <a href="/boardForm.do">
                    <button type="button">글쓰기</button>
                </a>
           	</div>
		</section>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div id= "container">
	    <section id="board_update">
			<h2>게시글 수정</h2>
			<form action="/boardUpdateProcess.do" method="post">
				<input type="hidden" name="bnum" value="${board.bnum }">
            	<table>
            		<tbody>
            			<tr>
            				<td><input type="text" name="title" value="${board.title}"></td>
            			</tr>
            			<tr>
            				<td><textarea rows="7" cols="100" 
            						name="content">${board.content}</textarea></td>
            			</tr>
            			<tr>
            				<td><c:out value="글쓴이: ${board.memberId}"/>
            					<c:choose>
            						<c:when test="${not empty board.modifyDate}">
            						  (수정일: <fmt:formatDate value="${board.modifyDate}" 
            						  				pattern="yyyy-MM-dd hh:mm:ss"/>)
            				    	</c:when>
	            				    <c:otherwise>
	            				   	  (작성일: <fmt:formatDate value="${board.regDate}" 
	            				   	  				pattern="yyyy-MM-dd hh:mm:ss"/>)
	            				   </c:otherwise>
            				   </c:choose>
            				</td>
            			</tr>
            			<tr>
                           <td>
                               <button type="submit">저장</button>
                               <button type="reset">취소</button>
                           </td>
                       </tr>
            		</tbody>
            	</table>
           	</form>
        </section>
	</div>
</body>
</html>
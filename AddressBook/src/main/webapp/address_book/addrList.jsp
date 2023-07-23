<%@page import="address.AddrBook"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 목록</title>
</head>
<jsp:useBean id="abDAO" class="address.AddrBookDAO" scope="application" />
<body>
	<div id="container">
		<h2>주소록</h2>
		<hr>
		<p><a href="addrForm.jsp">주소 추가</a></p>
		<table id="tbl_list">
			<tr>
				<td>이름</td><td>전화번호</td><td>이메일</td><td>성별</td><td>보기</td><td>삭제</td>
			</tr>
			<%
				for(int i=0; i<abDAO.getList().size(); i++){
					AddrBook addrBook = abDAO.getList().get(i);
			%>
			<tr>
				<td><%=addrBook.getUsername() %></td>
				<td><%=addrBook.getTel() %></td>
				<td><%=addrBook.getEmail() %></td>
				<td><%=addrBook.getGender() %></td>
				<td><a href="addrView.jsp?username=<%=addrBook.getUsername() %>">
					<button type="button">보기</button></a>
				</td>
				<td><a href="addrDelete.jsp?username=<%=addrBook.getUsername() %>"
				       onclick="return confirm('정말로 삭제하시겠습니까?')">
					<button type="button">삭제</button></a>
				</td>
			</tr>
			<% } %>
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>

<title>주소 추가</title>
<link rel="stylesheet" href="../resources/css/style.css">
<jsp:useBean id="addrBook" class="address.AddrBook" />
<jsp:setProperty property="username" name="addrBook"/>
<jsp:setProperty property="tel" name="addrBook"/>
<jsp:setProperty property="email" name="addrBook"/>
<jsp:setProperty property="gender" name="addrBook"/>
<jsp:useBean id="abDAO" class="address.AddrBookDAO" scope="application" />
<% 
	abDAO.add(addrBook); //주소 추가
%>
<div id="container">
	<h2>등록 내용</h2>
	<hr>
	<p>이름: <%=addrBook.getUsername() %>
	<p>전화번호: <%=addrBook.getTel() %>
	<p>이메일: <%=addrBook.getEmail() %>
	<p>성별: <%=addrBook.getGender() %>
	<hr>
	<a href="addrList.jsp">목록 보기</a>
</div>

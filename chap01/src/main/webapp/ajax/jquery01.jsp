<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
	    $("h2").css("color", "blue");
	    $(".intro").css("background", "greenyellow");
	    //$(".intro").next('p').css('font-weight', 'bold');
	    $('.intro').next('p').css({'font-weight':'bold', 'color':'red'});
	});
</script>
</head>
<body>
	<h2>어서오세요~ 방문을 환영합니다.</h2>
    <div class="info">
        <p class="intro">내 이름은 김초엽입니다.</p>
        <p>나는 서울에 살고 있어요.</p>
    </div>
</body>
</html>
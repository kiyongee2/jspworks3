<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax 예제</title>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script type="text/javascript">
	function fnProcess(){
		//alert("test");
		$.ajax({
			type: "get",
			url: "http://localhost:8080/ajax1",
			dataType: "text",
			data: {message: "안녕~ Server!"},
			success: function(data){
				$("#message").append(data);
			},
			error: function(){
				alert("에러 발생!");
			}
		});
	}
</script>
</head>
<body>
	<p><button type="button" onclick="fnProcess()">전송</button></p>
	<p id="message"></p>
</body>
</html>
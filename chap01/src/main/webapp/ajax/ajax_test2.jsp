<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax 예제</title>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("button").click(function(){
			//alert("test");
			let car = {
		    "brand" : "Avante",
		    "cc" : 2500,
		    "color" : "silver"
			}
			$.ajax({
				type: "get",
				url: "http://localhost:8080/chap01/ajax",
				dataType: "json",
				data: JSON.stringify(car),
				success: function(data){
					$("#demo").html("<h2>" + data + "</h2>");
				},
				error: function(){
					alert("에러 발생!");
				}
			});
		});
	});
</script>
</head>
<body>
	<div id="demo">
		<h2>버튼을 클릭하면 텍스트가 변경됩니다.</h2>
	</div>
	
	<button type=button>클릭</button>
</body>
</html>
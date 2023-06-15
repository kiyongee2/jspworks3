<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json 데이터 만들기</title>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		//객체를 문자열로 바꿔주는 함수 - 객체의 직렬화(Serialization)
		console.log(JSON.stringify({ x: 5, y: 6 }));
		console.log(JSON.stringify([new Number(3), new String('false'), new Boolean(false)]));
		console.log(JSON.stringify(new Date(2023, 5, 16)));
		
		let car = {
		    "brand" : "Avante",
		    "cc" : 2500,
		    "color" : "silver"
		}
		
		alert(JSON.stringify(car));
	});
</script>
</head>
<body>

</body>
</html>
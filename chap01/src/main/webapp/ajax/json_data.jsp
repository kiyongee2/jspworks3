<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json 데이터 만들기</title>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script>
	var test = {
	    "name" : "coco",
	    "age" : 99,
	    "address" : "서울시"
	}
	 
	$.ajax ( {
	    type : "get"
	    url : "http://localhost:8080/chap01/ajax/json_data.jsp",
	    dataType : 'json',
	    contentType : 'application/json',
	    data : JSON.stringify(test),
	    beforeSend : function() {
	        alert("ajax 호출시 실행");
	    },
	    success : function(res) {
	    	alert("success");    
	    },
	    error : function(xhr) {
	    	alert(xhr.responseText);
	    },
	    complete : function() {
	        alert("ajax 호출 완료시 실행");
	    }
	);
</script>
</head>
<body>

</body>
</html>
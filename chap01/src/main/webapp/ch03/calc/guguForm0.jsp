<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function check(){
		let form = document.form1;
		let dan = form.dan;
		
		if(dan.value == "" || isNaN(dan.value)){
			alert("숫자를 입력해 주세요");
			dan.focus();
			return false;
		}else if(dan < 1 || dan > 9){
			alert("1부터 9까지 입력가능합니다.")
			dan.select();
			return false;
		}
		else{
			form.submit();
		}
	}
	
</script>
</head>
<body>
	<form action="guguProcess.jsp" method="post" name="form1">
		<p>
			<label for="dan">단 </label>
			<input type="text" name="dan" id="dan">
		</p>
		<!-- <p><input type="submit" value="확인"></p> -->
		<p><input type="button" value="확인" onClick="check()"></p>
	</form>
</body>
</html>
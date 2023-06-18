<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" href="resources/css/style.css">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script type="text/javascript" src="resources/js/validation.js"></script>
<script type="text/javascript">
	function checkID(){
		//alert('test');
		//ID 중복 확인
		let memberId = $("#memberId").val();
		if(memberId == ""){
			alert("아이디를 입력해주세요");
			return false;
		}
		//ajax 실행
		$.ajax({
			type: "post",
			url: "checkid",
			dataType: "text",
			data: {id: memberId},  //서블릿쪽으로 id 보냄
			success: function(data){ //서블릿에서 응답 받음
				console.log(data);
				if($.trim(data)=='usable'){ //$.trim()- 앞,뒤 공백을 없애줌
					$("#btnChk").attr("value", "Y");  //체크 버튼이 눌러짐
					$("#check").text("사용 가능한 ID입니다.");
					$("#check").css({"color": "blue", "padding": "5px 0 0 10px"});
				}else{
					$("#check").text("이미 가입된 ID입니다.");
					$("#check").css({"color": "red", "padding": "5px 0 0 10px"});
				}
			},
			error: function(){
				alert("에러 발생!!");
			}
		});
	}
</script>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div id= "container">
	    <section id="register">
		<h2>회원 가입</h2>
		<form action="/addMember.do" method="post" name="member">
			<fieldset>
				<ul>
					<li>
						<label for="memberId">아이디 </label>
						<input type="text" id="memberId" name="memberId"
							placeholder="아이디는 4~15자까지 입력 가능합니다.">
						<button type="button" id="btnChk" value="N" 
								class="btn_check" onclick="checkID()" >ID 중복</button>
						<p id="check"></p>
					</li>
					<li>
						<label for="passwd1">비밀번호 </label>
						<input type="password" id="passwd1" name="passwd1"
							placeholder="비밀번호는 영문자, 숫자, 특수문자 포함 8자 이상입니다.">
					</li>
					<li>
						<label for="passwd2">비밀번호 확인</label>
						<input type="password" id="passwd2" name="passwd2"
							placeholder="비밀번호가 일치하지 않습니다.">
					</li>
					<li>
						<label for="name">이름 </label>
						<input type="text" id="name" name="name"
							placeholder="이름은 영문과 한글로 입력해주세요">
					</li>
					<li>
						<label for="name">성별 </label>
						<label class="radio">
							<input type="radio" name="gender" value="남" checked>남
						</label>
						<label class="radio">
							<input type="radio" name="gender" value="여">여
						</label>
					</li>
				</ul>
			</fieldset>
			<div class="button">
				<input type="button" value="가입" onclick="checkMember()">
				<input type="reset" value="취소">
			</div>
			</form>
        </section>
	</div>
</body>
</html>
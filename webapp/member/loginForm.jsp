<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" src="../script/memberScript.js"></script>
<style type="text/css">
body {
	margin: 0;
	height: 100%;
	font-family: Nanum Gothic, '나눔고딕', Helvetica, sans-serif;
}

#logo {
	cursor: pointer;
}

#header {
	padding-top: 60px;
	padding-bottom: 20px;
	text-align: center;
}

#wrapper {
	position: relative;
	height: 100%;
}

#content {
	position: absolute;
	left: 50%;
	transform: translate(-50%);
}

label {
	margin: 20px 0 10px;
	font-size: 15px;
	font-weight: 700;
}

span {
	display: block;
	width: 100%;
	height: 30px;
	position: relative;
	padding: 7px 3px 10px;
}
</style>
</head>
<body>
	<form action="login.do" method="post" name="loginForm">
   		<div id="header" align="center">
			<input id="logo" type="button" value="메인화면" onclick="location.href='../main/index.jsp'">
			<!-- 로고 이미지 상단 - 임시방편으로 버튼으로 뒀고, 로고 이미지 들어오면 메인화면으로 이동할 수 있도록 위에 뒀습니다. 혹 재배치 필요하다 싶으면 말씀해주세요 -->
		</div>
		
		<div id="wrapper">
		<div id="content"> 
			<div>
				<label>아이디</label>
				<span><input type="text" name="mem_id" size="25"></span>
			</div>
			
			<div>
				<label>비밀번호</label>
				<span><input type="password" name="passwd" size="25"></span>
			</div>
			
			<div>
				<span><input type="button" value="로그인" onclick="checkLogin()"></span>
				<span><input type="button" value="회원가입" onclick="location.href='writeForm.do'"></span>
			</div>
		</div>
		</div>     
	</form>
   
</body>
</html>





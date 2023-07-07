<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
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
	left: 40%;
	transform: translate(-60%);
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
	<div id="header" align="center">
		<input id="logo" type="button" value="메인화면" onclick="location.href='../main/index.jsp'">
		<!-- 로고 이미지 상단에 넣고 누르면 메인화면으로 이동할 수 있도록 위에 뒀습니다. 혹 재배치 필요하다 싶으면 말씀해주세요 -->
	</div>
	
	<div id="wrapper">
	<div id="content">
		<div>
			<label>이름</label>
			<span>${dto.mem_name }</span>
		</div>
		
		<div>
			<label>아이디</label>
			<span>${dto.mem_id }</span>
		</div>
		
		<div>
			<label>닉네임</label>
			<span>${dto.nickname }</span>
		</div>
		
		<div>
			<label>프로필 이미지</label>
			<span><img src="../profile_img/${dto.profile_image }" width="100" height="100"><br></span>
		</div>
		
		<div>
			<span><a href="../scrap/scrapBook.do">나의 스크랩북</a></span>
		</div>
		
		<br><br><br><br><br>
		
		<div>
			<span><input type="button" value="설정" onclick="location.href='../member/modifyForm.do'"></span>
		</div>
		
		<div>
			<br>
			사장님이라면?
			<span><input type="button" value="사업자신청" onclick="location.href='../member/businessForm.do'"></span>
			<br>
		</div>
	</div>
	</div>
</body>
</html>
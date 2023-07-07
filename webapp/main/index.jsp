<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EZin</title>
<style type="text/css">
body {
	margin: 0;
	height: 100%;
	font-family: Nanum Gothic, '나눔고딕', Helvetica, sans-serif;
}

.header {
	height: 20%;
	padding-left: 40px;
	padding-right: 40px;
}

#logo {
	cursor: pointer;
}

.header img {
	vertical-align: top;
}

.header #left_menu {
	float: left;
	list-style-type: none;
	padding: 0;
	margin: 0;
}

.header #right_menu {
	float: right;
	list-style-type: none;
	padding: 0;
	margin: 0;
}

.header li {
	float: left;
	margin-left: 50px;
	line-height: 60px;
}

.header #left_menu li a {
	color: #545454;
	font-size: 15px;
	font-weight: bold;
	text-decoration: none;
}

.header #right_menu li a {
	color: #545454;
	font-size: 13px;
	text-decoration: none;
}

.body-header {
	height: 45%;
}

.body-header img {
	border-radius: 10%;
	margin-left: 5px;
	margin-right: 5px;
}

.body-header #banner1 {
	margin-left: 10px;
	float: left;"
}

.body-header #banner2 {
	margin-left: 10px;
	float: left;
}

.body-menu {
	width: 90%;
	margin-left: 10%;
	margin-right: 10%;
	margin-bottom: 30px;
}
</style>
</head>
<body>
<div class="header">
	<a href="../main/index.jsp" id="logo">
		<img src="#" height="50">
	</a>
	<!-- 로고 이미지 상단 - 임시방편, 이미지 넣어주세요 -->
	
	<ul id="left_menu">
		<li><a href="#">스토어</a></li>
		<li><a href="#">커뮤니티</a></li>
	</ul>
	
	<c:if test="${mem_id == null }">
	<ul id="right_menu">
		<li><a href="../member/loginForm.jsp">로그인</a></li>
		<li><a href="../member/writeForm.jsp">회원가입</a></li>
		<li><a href="#">장바구니</a></li>
		<li><a href="#">글쓰기</a></li>
	</ul>
	</c:if>
	<c:if test="${mem_id != null }">
	<!-- 로그인 후 -->
		<ul id="right_menu">
		<li><a href="../member/logout.jsp">로그아웃</a></li>
		<li><a href="../member/mypage.jsp">마이페이지</a></li>
		<li><a href="#">장바구니</a></li>
		<li><a href="#">글쓰기</a></li>
		<li><a href="../member/deleteForm.jsp">회원탈퇴</a></li>
	</ul>
	</c:if>
</div>	

<div class="body-header">
	<!-- 큰 사진, 이벤트 홍보 배너, 신상.할인 물품 등의 배너 -->
	<a href="#" id="banner1">
		<img src="../main/index_banner1">
	</a>
	<a href="#" id="banner2">
		<img src="../main/index_banner2">
	</a>
</div>

<div class="body-menu" align="center">
	<a href="../product/ProductList.jsp" id="shop">
		<img src="#">
		<div id="icon_name1">
			쇼핑하기
		</div>
	</a>
	
	<a href="../houseboard/houseboardList.jsp" id="houseboard">
		<img src="#">
		<div id="icon_name2">
			랜선 집들이
		</div>
	</a>
	
	<a href="../service/serviceList.jsp" id="shop">
		<img src="#">
		<div id="icon_name3">
			고객센터
		</div>
	</a>
</div>

</body>
</html>
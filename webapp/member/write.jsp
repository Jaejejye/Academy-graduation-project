<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
#logo {
	cursor: pointer;
}

#header {
	padding-top: 60px;
	padding-bottom: 20px;
	text-align: center;
}
</style>
</head>
<body>
<div id="header" align="center">
	<input id="logo" type="button" value="메인화면" onclick="location.href='../main/index.jsp'">
	<!-- 로고 이미지 상단 - 임시방편으로 버튼으로 뒀고, 로고 이미지 들어오면 메인화면으로 이동할 수 있도록 위에 뒀습니다. 혹 재배치 필요하다 싶으면 말씀해주세요 -->
</div>
	
<c:if test="${result > 0 }">
	<p>회원 가입 성공</p>
</c:if>		

<c:if test="${result < 0 }">
	<p>회원 가입 실패</p>
</c:if>
</body>   
</html>
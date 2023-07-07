<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사업자 회원 등록</title>
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
   <form action="business.do" method="post" name="businessForm">
   	<div id="header" align="center">
		<input id="logo" type="button" value="메인화면" onclick="location.href='../main/index.jsp'">
		<!-- 로고 이미지 상단 - 임시방편으로 버튼으로 뒀고, 로고 이미지 들어오면 메인화면으로 이동할 수 있도록 위에 뒀습니다. 혹 재배치 필요하다 싶으면 말씀해주세요 -->
	</div>

	<div id="wrapper">
	<div id="content"> 
	<input type="hidden" name="mem_id" value="${mem_id }">
		<div>
			<label>사업자번호</label>
			<span><input type="text" name="buis_num"></span>
		</div>
			
		<div>
			<label>경영자 이름</label>
			<span><input type="text" name="ceo_name"></span>
		</div>
		
		<div>
			<label>사업명</label>
			<span><input type="text" name="buis_name"></span>
		</div>
		
		<div>
			<label>개업일</label>
			<span>
				<input type="text" name="buis_open" placeholder="1900-01-01">
            </span>
		</div>
		
		<div>
			<label>사업분야</label>
			<span>
				<input type="text" name="buis_item" placeholder="사업 분야 또는 판매 물품 카테고리를 작성해주세요. (ex. 가구)">
			</span>
		</div>
		
		<div>
			<span><input type="submit" value="사업자신청"></span>
			<br><br>
		</div>
      
   </div>
   </div>
   </form>
</body>
</html>
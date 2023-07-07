<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<script type="text/javascript" src="../script/memberScript.js?v=1"></script>
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
   <form action="modify.do" method="post" name="modifyForm">
   	<div id="header" align="center">
		<input id="logo" type="button" value="메인화면" onclick="location.href='../main/index.jsp'">
		<!-- 로고 이미지 상단 - 임시방편으로 버튼으로 뒀고, 로고 이미지 들어오면 메인화면으로 이동할 수 있도록 위에 뒀습니다. 혹 재배치 필요하다 싶으면 말씀해주세요 -->
	</div>

	<div id="wrapper">
	<div id="content"> 
	<input type="hidden" name="mem_id" value="${mem_id }">
		<div>
			<label>비밀번호</label>
			<span><input type="password" name="passwd" value="${dto.getPasswd() }"></span>
		</div>
			
		<div>
			<label>비밀번호 확인</label>
			<span><input type="password" name="repasswd" value="${dto.getPasswd() }"></span>
		</div>
		
		<div>
			<label>닉네임</label>
			<span>
				<input type="text" name="nickname" value="${dto.getNickname() }">
			</span>
		</div>
		
		<div>
			<label>이메일</label>
			<span>
				<input type="text" name="email1" value="${dto.getEmail1() }">
				@
            	<select name="email2">
            		<option>선택해주세요</option>
               		<option value="naver.com">naver.com</option>
               		<option value="hanmail.net">hanmail.net</option>
               		<option value="daum.net">daum.net</option>
               		<option value="gmail.com">gmail.com</option>
               		<option value="nate.com">nate.com</option>
               		<option value="hotmail.com">hotmail.com</option>
               		<option value="outlook.com">outlook.com</option>
               		<option value="icloud.com">icloud.com</option>
            	</select>
            </span>
		</div>
		
		<div>
			<label>전화번호</label>
			<span>
				<select name="phone1">
					<option>선택해주세요</option>
               		<option value="010">010</option>
               		<option value="070">070</option>
               		<option value="02">02</option>
               		<option value="031">031</option>
            	</select>
            	-
            	<input type="text" name="phone2" size="15" value="${dto.getPhone2() }">
            	-
            	<input type="text" name="phone3" size="15" value="${dto.getPhone3() }">
			</span>
		</div>
		
		<div>
			<label>우편번호</label>
			<span><input type="text" name="zipcode" value="${dto.getZipcode() }"></span>
		</div>
			
		<div>
			<label>주소</label>
			<span>
				<input type="text" name="add1" value="${dto.getAdd1() }">
				<input type="text" name="add2" value="${dto.getAdd2() }" placeholder="상세주소">
			</span>
		</div>
			
		<div>
			<label>프로필 이미지</label>
			<span><input type="file" name="profile_image" size="35" value="${dto.getProfile_image() }"></span>
		</div>
		
		<div>
			<span><input type="button" value="회원정보수정" onclick="checkModify()"></span>
			<br><br>
		</div>
		
		<div>
			<span><input type="button" value="회원탈퇴" onclick="location.href='../member/deleteForm.do'"></span>
			<br>
		</div>
      
   </div>
   </div>
   </form>
</body>
</html>


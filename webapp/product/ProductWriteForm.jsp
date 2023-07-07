<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
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

textarea {
	width: 90%;
	height: 15px;
	position: relative;
}

#prod_content {
	display: block;
	width: 100%;
	height: 130px;
	position: relative;
	padding: 7px 3px 10px;
}

#prod_context {
	height: 90%;
}
</style>
</head>
<body>
	<form action="ProductWrite" enctype="multipart/form-data" method="post">
	<div id="header" align="center">
		<h3>상품 등록</h3>
		<input id="logo" type="button" value="메인화면" onclick="location.href='../main/index.jsp'">
		<!-- 로고 이미지 상단 - 임시방편으로 버튼으로 뒀고, 로고 이미지 들어오면 메인화면으로 이동할 수 있도록 위에 뒀습니다. 혹 재배치 필요하다 싶으면 말씀해주세요 -->
	</div>
	
	<div id="wrapper">
	<div id="content"> 
	<input type="hidden" name="mem_id" value="${mem_id }">
	<input type="hidden" name="mem_num" value="${mem_num }">
		<div>
			<label>상품 코드</label>
			<span><input type="text" name="prod_num" size="40"></span>
		</div>
		
		<div>
			<label>상품명</label>
			<span><input type="text" name="prod_name" size="40"></span>
		</div>
		
		<div>
			<label>가격</label>
			<span><input type="text" name="prod_price" size="20"></span>
		</div>
		
		<div>
			<label>배송비</label>
			<span><textarea name="delive_price" size="20"></textarea></span>
		</div>
		
		<div>
			<label>옵션1</label>
			<span><textarea name="prod_option1" size="40"></textarea></span>
		</div>
		
		<div>
			<label>옵션2</label>
			<span><textarea name="prod_option2" size="40"></textarea></span>
		</div>
		
		<div>
			<label>상품 내용</label>
			<span id="prod_content"><textarea id="prod_context" name="prod_content" size="40"></textarea></span>
		</div>
		
		<div>
			<label>이미지 등록</label>
			<span><input type="file" name="prod_img" size="45"></span>
		</div>
			
		<div>
			<label>상품파일명</label>
			<span><textarea name="prod_filename" size="40"></textarea></span>
		</div>
			
		<div>
			<label>상품 썸네일 이미지 등록</label>
			<span><input type="file" name="thumbnail_img" size="45"></span>
		</div>
		
		<div>
			<label>수량</label>
			<span><textarea name="prod_quan" size="20"></textarea></span>
		</div>
		
		<div>
			<label>추가 상품명</label>
			<span><textarea name="add_product" size="40"></textarea></span>
		</div>
		
<!--	<div>
			<label>상품등록일</label>
			<span><textarea name="prod_reg_date" size="40"></textarea></span>
		</div>
 -->		
		<div>
			<label>상품키워드</label>
			<span><textarea name="prod_keyword" size="40"></textarea></span>
		</div>
			
		<div>
			<label>상품 분류</label>
			<span><textarea name="prod_cate" size="40"></textarea></span>
		</div>
		
		<div>
			<label>옵션3</label>
			<span><textarea name="prod_option3" size="40"></textarea></span>
		</div>
		
		<div>
			<label>옵션4</label>
			<span><textarea name="prod_option4" size="40"></textarea></span>
		</div>
		
		<div>
			<label>옵션5</label>
			<span><textarea name="prod_option5" size="40"></textarea></span>
		</div>
		
		<div>
			<label>옵션6</label>
			<span><textarea name="prod_option6" size="40"></textarea></span>
		</div>
		
		<div>
			<label>옵션7</label>
			<span><textarea name="prod_option7" size="40"></textarea></span>
		</div>
		
		<div>
			<label>옵션8</label>
			<span><textarea name="prod_option8" size="40"></textarea></span>
		</div>
		
		<div>
			<label>옵션9</label>
			<span><textarea name="prod_option9" size="40"></textarea></span>
		</div>
		
		<div>
			<label>옵션10</label>
			<span><textarea name="prod_option10" size="40"></textarea></span>
			<br>
		</div>
		
		<div>
			<span><input type="submit" value="상품등록"></span>
			<br>
		</div>
		
		<div>
			<span><input type="reset" value="다시작성"></span>
			<br>
		</div>
	</div>
	</div>
	</form>
</body>
</html>
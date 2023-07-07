<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 보기</title>
</head>
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
<body>
	<div id="header" align="center">
		<input id="logo" type="button" value="메인화면" onclick="location.href='../main/index.jsp'">
		<!-- 로고 이미지 상단 - 임시방편으로 버튼으로 뒀고, 로고 이미지 들어오면 메인화면으로 이동할 수 있도록 위에 뒀습니다. 혹 재배치 필요하다 싶으면 말씀해주세요 -->
	</div>
	
	<div id="wrapper">
	<font size="5">${dto.prod_name() }</font>
	<div id="content">
		
	</div>
	</div> 
               
    <td width="150">상품명 : ${dto.Prod_name() }</td>
    <td width="150">상품 코드  : ${dto.prod_num}</td>
	<td width="150">상품 이미지 : ${dto.prod_img}</td>
	<td width="150"><img alt="" src="../storage/${dto.prod_img}"></td>
	<td width="150">가격 : ${dto.prod_price}</td>
	<td width="150">배송비 : ${dto.delive_price}</td>
	<td width="150">배송유형 : ${dto.delive_type}</td>
	<td width="150">옵션1 : ${dto.prod_option1}</td>
	<td width="150">옵션2 : ${dto.prod_option2}</td>
	<td width="150">상품파일명 : ${dto.prod_filename}</td>
	<td width="150">상품 썸네일 이미지  : ${dto.thumbnail_img}</td>
	<td width="150">수량 : ${dto.prod_quan}</td>
	<td width="150">추가 상품명 : ${dto.add_product}</td>
	<td width="150">상품등록일 : ${dto.prod_reg_date}</td>
	<td width="150">상품키워드 : ${dto.prod_keyword}</td>
	<td width="150">회원번호 : ${dto.mem_num}</td>
	<td width="150">상품 분류 : ${dto.prod_cate}</td>
	<td width="150">옵션3 : ${dto.prod_option3}</td>
	<td width="150">옵션4 : ${dto.prod_option4}</td>
	<td width="150">옵션5 : ${dto.prod_option5}</td>
	<td width="150">옵션6 : ${dto.prod_option6}</td>
	<td width="150">옵션7 : ${dto.prod_option7}</td>
	<td width="150">옵션8 : ${dto.prod_option8}</td>
	<td width="150">옵션9 : ${dto.prod_option9}</td>
	<td width="150">옵션10: ${dto.prod_option10}</td>
      </tr>
      
      <tr>
         <td colspan="3" valign="top" height="200">
            <pre>${dto.getProd_content() }</pre>
         </td>
      </tr>      
  	</table>
  	
	<input type="button" value="목록" onclick="location.href='productList.do?pg=${pg}'">
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	상품 코드  : ${dto.prod_num}<br>
	상품 이미지 : ${dto.prod_img}<br>
	<img alt="" src="../storage/${dto.prod_img}">
	가격 : ${dto.prod_price}<br>
	배송비 : ${dto.delive_price}<br>
	배송유형 : ${dto.delive_type}<br>
	옵션1 : ${dto.prod_option1}<br>
	옵션2 : ${dto.prod_option2}<br>
	상품 내용 : ${dto.prod_content}<br>
	상품파일명 : ${dto.prod_filename}<br>
	상품 썸네일 이미지  : ${dto.thumbnail_img}<br>
	수량 : ${dto.prod_quan}<br>
	추가 상품명 : ${dto.add_product}<br>
	상품등록일 : ${dto.prod_reg_date}<br>
	상품키워드 : ${dto.prod_keyword}<br>
	회원번호 : ${dto.mem_num}<br>
	상품 분류 : ${dto.prod_cate}<br>
	옵션3 : ${dto.prod_option3}<br>
	옵션4 : ${dto.prod_option4}<br>
	옵션5 : ${dto.prod_option5}<br>
	옵션6 : ${dto.prod_option6}<br>
	옵션7 : ${dto.prod_option7}<br>
	옵션8 : ${dto.prod_option8}<br>
	옵션9 : ${dto.prod_option9}<br>
	옵션10: ${dto.prod_option10}<br>
</body>
</html>
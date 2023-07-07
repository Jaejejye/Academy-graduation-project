<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스토어 - 상품목록</title>
<style type="text/css">
.paging {
	color: blue;
	text-decoration: none;
}

.currentPaging {
	color: red;
	text-decoration: none;
}

#subjectA {
	color: black;
	text-decoration: none;
}

#subjectA:hover {
	color: green;
	text-decoration: underline;
}
</style>

</head>
<body>
<div class="header" align="center">
	<a href="../main/index.jsp" id="logo">
		<img src="#" height="50">
	</a>
	<!-- 로고 이미지 상단 - 임시방편, 이미지 넣어주세요 -->
	
	<ul id="left_menu">
		<li><a href="#">스토어</a></li>
		<li><a href="#">커뮤니티</a></li>
	</ul>
	
	<ul id="right_menu">
		<li><a href="../member/loginForm.jsp">로그인</a></li>
		<li><a href="../member/writeForm.do">회원가입</a></li>
		<li><a href="#">장바구니</a></li>
		<li><a href="#">글쓰기</a></li>
	</ul>
</div>

<div id="wrapper">
	<div id="category"></div>
	<div id=""></div>
</div>
	<table border="1" width="540">
		<tr align="center" bgcolor="#ffff00">
			<td width="150">상품명</td>
			<td width="150">상품 코드</td>
			<td width="150">가격</td>
			<td width="150">상품 썸네일 이미지</td>
			<td width="150">상품키워드</td>
			<td width="150">상품 분류</td>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr align="center" bgcolor="#ffffcc">
				<td>${dto.getProd_name()}</td>
				<td>${dto.getProd_num() }</td>
				<td>${dto.getProd_name() }</td>
				<td>${dto.getProd_price() }</td>
				<td>${dto.getDelive_price() }</td>
				<td>${dto.getDelive_type() }</td>
				<td>${dto.getProd_option1() }</td>
				<td>${dto.getProd_option2()}</td>
				<td>${dto.getProd_content() }</td>
				<td>${dto.getProd_img()}</td>
				<td>${dto.getProd_filename() }</td>
				<td>${dto.getThumbnail_img()}</td>
				<td>${dto.getThumbnail_filename() }</td>
				<td>${dto.getProd_quan() }</td>
				<td>${dto.getAdd_product() }</td>
				<td>${dto.getProd_reg_date() }</td>
				<td>${dto.getProd_keyword() }</td>
				<td>${dto.getMem_num() }</td>
				<td>${dto.getProd_cate() }</td>
				<td>${dto.getProd_option3() }</td>
				<td>${dto.getProd_option4() }</td>
				<td>${dto.getProd_option5() }</td>
				<td>${dto.getProd_option6()}</td>
				<td>${dto.getProd_option7() }</td>
				<td>${dto.getProd_option8() }</td>
				<td>${dto.getProd_option9() }</td>
				<td>${dto.getProd_option10() }</td>

			</tr>
		</c:forEach>

		<!-- 페이징 -->
		<tr>
			<td colspan="5" align="center">
			<c:if test="${startPage > 3 }">
				<a class="paging" href="ProductList.do?pg=${startPage - 1 }">[이전]</a>
			</c:if> 
			<c:forEach var="i" begin="${startPage }" end="${endPage}" step="1">
				<c:if test="${i == pg}">
					<a class="currentPaging">[${i}]</a>
				</c:if>

				<c:if test="${i != pg}">
					<a class="paging" href="productList.do?pg=${i}">[${i}]</a>
				</c:if>
			</c:forEach> 
			<c:if test="${endPage < totalP }">
				<a class="paging" href="productList.do?pg=${endPage + 1 }">[다음]</a>
			</c:if>
			</td>
		</tr>
	</table>

</body>
</html>
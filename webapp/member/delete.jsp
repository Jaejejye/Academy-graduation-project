<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(${result > 0}) {
		alert("회원 탈퇴에 성공했습니다.");
	} else {
		alert("회원 탈퇴에 실패하였습니다.");
	}
	
	location.href = "../main/index.jsp";
</script>
</head>
<body>

</body>
</html>
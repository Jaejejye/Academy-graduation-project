function checkWrite() {
   // form 객체 구하기
   var frm = document.frm;
   
   if(!frm.mem_name.value) {
      alert("이름을 입력하세요.");
      frm.mem_name.focus();
   } else if(!frm.mem_id.value) {
      alert("아이디를 입력하세요.");
      frm.mem_id.focus();
   } else if(!frm.passwd.value) {
      alert("비밀번호를 입력하세요.");
      frm.passwd.focus();
   } else if(frm.passwd.value != frm.repasswd.value) {
      alert("비밀번호가 맞지 않습니다.");
      frm.repasswd.focus();
   } else {
      frm.submit();
   }
}

function checkLogin() {
   var frm = document.loginForm;
   
   if(!frm.mem_id.value) {
      alert("아이디를 입력하세요.");
      frm.mem_id.focus();   
   } else if(!frm.passwd.value) {
      alert("비밀번호를 입력하세요.");
      frm.passwd.focus();
   } else {
      frm.submit();
   }
}

function checkId() {
	var sId = document.frm.mem_id.value;
	
	// 입력 검사
	if(sId == "") {
		alert("먼저 아이디를 입력하세요.");
		document.frm.mem_id.focus();
	} else {
		window.open("checkId.do?mem_id=" + sId, "", "width=450 height=150 left=500 top=200");
	}
}

function checkModify() {
   // form 객체 얻어오기	
   var frm = document.modifyForm;
   
   if(!frm.passwd.value) {
      alert("비밀번호를 입력하세요.");
      frm.passwd.focus();
   } else if(frm.passwd.value != frm.repasswd.value) {
      alert("비밀번호가 맞지 않습니다.");
      frm.repasswd.focus();
   } else {
      frm.submit();
   }
}



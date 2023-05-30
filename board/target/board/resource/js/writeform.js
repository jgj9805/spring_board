//정규식
//아이디, 비밀번호 영문 대소문자 , 숫자, 최소3자 이상 8자 이하
const uidPw = /^[a-zA-Z0-9]{4,8}$/;

//이름
const uname = /^[가-힣a-zA-Z]{2,15}$/;

function bbswrite(){
	//변수 정의

	const username = document.getElementById("username"); 
	const listtitle = document.getElementById("listtitle"); 
	const content = document.getElementById("content"); 

	
	if(listtitle.value==""){
		alert("제목!");
		listtitle.focus();
		return false;
	}	
	else if(username.value==""){
		alert("이름을 입력 하세요.");
		username.focus();
		return false;
	}	
	else if(!uname.test(username.value)){
		alert("이름은 한글 또는 영문으로 2자 이상 적어 주세요.");
		username.focus();
		return false;
	}
	else if(content.value==""){
		alert("내용!");
		content.focus();
		return false;
	}	

	document.writeform.submit();
}

function Cboardupdate(){
	

	const username = document.getElementById("username"); 
	const listtitle = document.getElementById("listtitle"); 
	const content = document.getElementById("content"); 

	
	if(listtitle.value==""){
		alert("제목!");
		listtitle.focus();
		return false;
	}	
	else if(username.value==""){
		alert("이름을 입력 하세요.");
		username.focus();
		return false;
	}	
	else if(!uname.test(username.value)){
		alert("이름은 한글 또는 영문으로 2자 이상 적어 주세요.");
		username.focus();
		return false;
	}
	else if(content.value==""){
		alert("내용!");
		content.focus();
		return false;
	}	

	document.cboradlistupdateform.submit();
}




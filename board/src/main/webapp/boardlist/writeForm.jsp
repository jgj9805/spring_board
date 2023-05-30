<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! String user =""; %>
<%user = (String) session.getAttribute("user"); %>   
	<h1 class="my-5 text-center">게시판 글 작성</h1>
  <form name="writeform" class="writeform" action="/board/BoardOk" method="post">
  <div class="container">
           <div class="row my-3">
              <label for="listtitle" class="form-label col-md-1">제목 :</label>
             <div class="col-md-6">
				<input type="text" class="form-control"  id="listtitle" placeholder="제목을 입력하세요." name="listtitle"/>
			</div>
			<div class="col-md-5">
			
			</div>
		</div>    
         <div class="row my-3">
              <label for="username" class="form-label col-md-1">작성자 :</label>
             <div class="col-md-3">
				<input type="text" class="form-control mx-2"  id="username" placeholder="이름을 입력하세요." name="username"/>
			</div>
			<div class="col-md-5">
			
			</div>
		</div>
		 <div class="row my-3">
              <label for="userid" class="form-label col-md-1">아이디 :</label>
             <div class="col-md-3">
				<input type="text" class="form-control mx-2"  id="userid" placeholder="아이디를 입력하세요." name="userid"/>
			</div>
			<div class="col-md-5">
			
			</div>
		</div>
          <div>
              <label for="content" class="form-label col-md-1">내용</label>
              <textarea name="content" id="content" rows="20" cols="150" style="resize: none"></textarea>
          </div>    
   
		<div class="form-btn py-4 text-center">
			<button type="button" class="btn btn-primary mx-3 px-4" onclick="bbswrite();">전송</button>
		</div>
  </div>
  </form>
  	<%
	if(user==null){
	%>
	<script>
		alert("로그인을 해주세요");
		location.href="/board/index.jsp?fname=member/login"
	</script>
	<%
	}
	%>
<script src="resource/js/writeform.js"></script>
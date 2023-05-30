<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, board.BoardDDL, board.BoardDTO"%>
 
<jsp:useBean id="bbs" class="board.BoardDDL" scope="page" />
<jsp:useBean id="dto" class="board.BoardDTO" scope="page" />

<%

	int str = Integer.parseInt(request.getParameter("num"));
	Vector data = bbs.BoardSelect(str);

		BoardDTO dt = (BoardDTO) data.elementAt(0);
		String listtitle = dt.getListtitle();
		String username = dt.getUsername();
		String content = dt.getContent();
		String listdate = dt.getListdate();
		int num = dt.getNum();
%>

<div class="container lcboard">
<form name="cboradlistupdateform" class="cboradlistupdateform" action="/board/CBoardUpdate" method="post">
<table class="table table-striped boardstbl">
			<thead>
				<tr>
					<th> 
					<div class="row">
					<label for="listtitle" class="form-label col-md-1">제목 :</label>
						<div class="col-md-5">
                			<input type="text" class="form-control" id="listtitle" name="listtitle" value="<%=listtitle%>"/>
						</div>
						<div class="col-md-6">
						</div>
					</div>
            		</th>
				</tr>
				<tr>
					<th>
					<div class="row">
					<label for="username" class="form-label col-md-1">이름 :</label>
						<div class="col-md-3">
                			<input type="text" class="form-control" id="username" name="username" value="<%=username%>"/>
						</div>
						<div class="col-md-8">
						</div>
					</div>
					</th>
				</tr>	
				<tr>
					<th>
					<label for="content" class="form-label col-md-1">내용</label>
						<div class="col-md-3">
                			 <textarea name="content" id="content" rows="20" cols="150" style="resize: none" ><%=content %></textarea>
						</div>
						<div class="col-md-8">
						</div>
					</th>
				</tr>	
			</thead>
		</table>
		<input type="hidden" id="num" name="num" value="<%=num %>" />	
		<div class="form-btn py-4 text-center">
			<button type="button" class="btn btn-warning mx-3 px-4" onclick="Cboardupdate()">수정</button>
		</div>
</form>
</div>
<script src="resource/js/writeform.js"></script>
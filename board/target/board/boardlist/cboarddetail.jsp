<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*, board.BoardDDL, board.BoardDTO"%>
<jsp:useBean id="bbs" class="board.BoardDDL" scope="page" />
<jsp:useBean id="dto" class="board.BoardDTO" scope="page" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%! String user =""; %>
<% user = (String) session.getAttribute("user"); %>
<%
	int str1 = Integer.parseInt(request.getParameter("num"));
	Vector data = bbs.BoardSelect(str1);

		BoardDTO dt = (BoardDTO) data.elementAt(0);
		int num = dt.getNum();
		String listtitle = dt.getListtitle();
		String username = dt.getUsername();
		String userid= dt.getUserid();
		String listdate = dt.getListdate();
		String content = dt.getContent();

%>
<div class="container lcboard">
	<h1 class="mt-3 mb-5 text-center">컬럼 게시판 목록</h1>
	<div class="row">
		<table class="table table-striped boardstbl">
			<thead>
				<tr>
					<th>제목 : <%=listtitle %> </th>
				</tr>
				<tr>
					<th>이름 : <%=username %></th>
				</tr>	
				<tr>
					<th>작성일 : <%=listdate %></th>
				</tr>
				<tr>
					<th>내용</th>
				</tr>		
					
			</thead>
			<tbody>

	<tr>
		<td><%=content %></td>
	</tr>

			</tbody>
		</table>
	</div>
		<div class="form-btn py-4 text-end">
		<%
		try {
  			if (user.equals(userid)) {
		%>
		<div class="form-btn py-4">
			<a href="?fname=boardlist/cboardlistupdate&num=<%=num %>" class="btn btn-warning mx-3 px-4">수정</a>
			<button type="button" class="btn btn-danger mx-3 px-4" onclick="deleteAction(<%=num %>);">삭제</button>
		</div>
		<%
 	 		}
		} catch (Exception e) {
  
		}
%>
		</div>
<script src="resource/js/form.js"></script>
</div>
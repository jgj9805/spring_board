<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, board.BoardDDL, board.BoardDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 


<jsp:useBean id="bbs" class="board.BoardDDL" scope="page" />
<jsp:useBean id="dto" class="board.BoardDTO" scope="page" />
<%!
	int listNum = 10; //한 페이지 당 보여줄 블럭 수
	int pageNum = 15; //한 블럭당 보여줄 페이지 수
%>
<%
	String pg = request.getParameter("page");
	int mypg = 1;
	try{
		mypg = Integer.parseInt(pg);
		if(mypg < 1) mypg = 1;
	}catch(Exception e){
		mypg = 1;
	}
	int limitNum = (mypg - 1)*listNum;

	Vector data = bbs.getSelect(limitNum, listNum);
	int maxColumn = bbs.getAllSelect();
	int size = data.size();
	
	/*
		1.전체페이지 수 2.전체블록수 3.현재 블록번호 4.블록당 시작번호 5.블록당 마지막 번호
	*/
	
	int totalPage = (int) Math.ceil(maxColumn / (double)listNum);
	int totalBlock = (int) Math.ceil(totalPage / (double)pageNum);
	int nowBlock = (int) Math.ceil(mypg / (double)pageNum);
	int startNum = (nowBlock - 1)*pageNum + 1;
	int endNum = nowBlock * pageNum;
	if(endNum > totalPage) endNum = totalPage;
%>  

<div class="container lcboard">
	<h1 class="mt-3 mb-5 text-center">컬럼 게시판 목록</h1>
	<div class="row">
		<table class="table table-striped boardstbl">
			<thead>
				<tr>
					<th>번호 </th>
					<th>이름</th>
					<th>제목</th>
					<th>내용</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
<%
	for(int i=0; i < size; i++){
		BoardDTO dt = (BoardDTO) data.elementAt(i);
		int num = dt.getNum();
		String username = dt.getUsername();
		String listtitle = dt.getListtitle();
		String userid = dt.getUserid();
		String content = dt.getContent();
		String listdate = dt.getListdate();
		int viewnum = dt.getViewnum();
	
%>
	<tr>
		<td><%=num %></td>
		<td><%=username %></td>
		<td><%=listtitle %></td>
		<td><a href="/board/index.jsp?fname=boardlist/cboarddetail&num=<%=num %>" class="boardcontent" ><%=content  %></a></td>
		<td><%=listdate %></td>
		<td><%=viewnum %></td>
	</tr>
<%
			
	}
%>

			</tbody>
		</table>
	</div>
	<div class="mt-3 mb-5 row">
		<ul class="pagination justify-content-center">
			<%
				//이전페이지
				if(startNum > 1){
					int prevPage = startNum - 1;
					out.print("<li class=\"page-item\"><a class=\"page-link\" href=\"?fname=boardlist/cboardlist&page="+prevPage+"\">Previous</a></li>");
				}else{
					out.print("<li class=\"page-item\"><a class=\"page-link text-muted\" href=\"javascript:void(0)\">이전</a></li>");
				}
				//페이지 출력
				for(int i = startNum; i<=endNum; i++){
					String act = "";
					if(mypg == i) act = "active";
				
			%>
				<li class="page-item <%=act %>"><a href="?fname=boardlist/cboardlist&page=<%=i %>" class="page-link"><%=i %></a></li>
			<%
				}
				//다음 페이지
				if(endNum < totalPage){
					int nextPage = endNum + 1;
					out.print("<li class=\"page-item\"><a class=\"page-link\" href=\"?fname=boardlist/cboardlist&page="+nextPage+"\">Next</a></li>");
				}else{
					out.print("<li class=\"page-item\"><a class=\"page-link text-muted\" href=\"javascript:void(0)\">다음</a></li>");
				}
	
			%>
		</ul>
	</div>
	<a href="/board/index.jsp?fname=boardlist/writeForm" class="btn btn-primary mx-3 px-4" style="float:right" onclick="cwrite()">글쓰기</a>
</div>

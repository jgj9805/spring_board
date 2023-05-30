package gyu.net;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDDL;
import board.BoardDTO;

/**
 * Servlet implementation class CBoardUpdate
 */
@WebServlet("/CBoardUpdate")
public class CBoardUpdate extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		  BoardDTO dto = new BoardDTO ();
	      BoardDDL ddl = new BoardDDL();
	      String url = null;


	      dto.setListtitle(req.getParameter("listtitle"));
	       dto.setUsername(req.getParameter("username"));
	      dto.setContent(req.getParameter("content"));
	      dto.setListdate();
	      dto.setNum(Integer.parseInt(req.getParameter("num")));
	     
	      
	      boolean isSuccess = ddl.update(dto);
		
	      if(isSuccess)
	      {
	    	 url = "/board/index.jsp?fname=boardlist/cboardlist";
	    	 res.sendRedirect(url);
	      }
	      else
	      {
	    	 url = "/board/index.jsp?fname=boardlist/cboardlist";
	    	 res.sendRedirect(url);
	      }
	      
	      doGet(req, res);
	   }
	

}

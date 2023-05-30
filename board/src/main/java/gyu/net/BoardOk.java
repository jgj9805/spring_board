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
 * Servlet implementation class BoardOk
 */
@WebServlet("/BoardOk")
public class BoardOk extends HttpServlet {

	   protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	        
	   }

	   protected void doPost(HttpServletRequest req, HttpServletResponse res) 
	         throws ServletException, IOException {
	      BoardDTO dto = new BoardDTO ();
	      BoardDDL ddl = new BoardDDL();
	      String url = null;


	      dto.setListtitle(req.getParameter("listtitle"));
	       dto.setUsername(req.getParameter("username"));
	       dto.setUserid(req.getParameter("userid"));
	      dto.setContent(req.getParameter("content"));

	      boolean isSuccess = ddl.insert(dto);
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

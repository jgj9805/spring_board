package gyu.net;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDDL;
import board.BoardDTO;


@WebServlet("/DeleteAction")
public class DeleteAction extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		BoardDTO dto = new BoardDTO ();
	      BoardDDL ddl = new BoardDDL();
	      String url = null;

	      dto.setNum(Integer.parseInt(req.getParameter("num")));
	      
	      boolean isSuccess = ddl.delete(dto);
	   
	      
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
}


}

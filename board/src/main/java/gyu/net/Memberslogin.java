package gyu.net;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.MemberDDL;
import board.MembersDTO;


public class Memberslogin extends HttpServlet {


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MembersDTO dto = new MembersDTO();
		MemberDDL db = new MemberDDL();
		String url = null;
		
		//MembersDTO에 setter로 파라미터 정보를 보낸 후 db에서 getter로 받을 수 있도록 함.
		dto.setUserid(req.getParameter("userid"));
		dto.setUserpass(req.getParameter("userpass"));
		
		//MemberDDL의 매개변수 MembersDTO를 받아 getter를 통해 db를 select해서 조사
		//결과를 true, false로 출력함
		int isSuccess = db.checkLogin(dto);
		if(isSuccess > 0) {
			//세션 등록
			url = "index.jsp";
			HttpSession session = req.getSession();
			session.setAttribute("user", req.getParameter("userid"));
			session.setAttribute("level", isSuccess);
			res.sendRedirect(url);
		}else {
			url = "/index.jsp?fname=member/login";
			req.setAttribute("message", "아이디 또는 비밀번호가 틀렸습니다.");
			//forward를 통해 변수를 전달 시킨다.
			req.getRequestDispatcher(url).forward(req, res);
		}
		
		doGet(req, res);
	}

}

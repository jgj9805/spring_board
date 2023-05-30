package gyu.net;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.MemberDDL;
import board.MembersDTO;

public class MemberOk extends HttpServlet {


   protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

      
      
   }

   protected void doPost(HttpServletRequest req, HttpServletResponse res) 
         throws ServletException, IOException {
	   MembersDTO dto = new MembersDTO();
	      MemberDDL ddl = new MemberDDL();
	      String url = null;
	      
	      //업로드 경로
	      String dir = req.getSession().getServletContext().getRealPath("/upload/users");
	      
	      //업로드 파일용량 설정 - 최대 10MB
	      int max = 10 * 1024 * 1024;

	      //System.out.println("포스트코드" + req.getParameter("postcode"));
	      
	      try
	      {
	         MultipartRequest m = new MultipartRequest(req,dir,max,"UTF-8",
	         new DefaultFileRenamePolicy());
	         
	         dto.setUserid(m.getParameter("userid"));
	         dto.setUserpass(m.getParameter("userpass"));
	         dto.setUsername(m.getParameter("username"));
	         dto.setUseremail(m.getParameter("useremail"));
	         dto.setPostcode(Integer.parseInt(m.getParameter("postcode")));
	         dto.setAddr(m.getParameter("addr"));
	         dto.setDetailaddr(m.getParameter("detailaddr"));
	         dto.setTel(m.getParameter("tel"));
	         dto.setUip();
	         dto.setPhoto(m.getFilesystemName("photo"));
	      }
	      catch(Exception e){}
	      
	      boolean isSuccess = ddl.insert(dto);

      if(isSuccess)
      {
         System.out.println("insert success");
      }
      else
      {
         System.out.println("insert failed");
      }
      
      doGet(req, res);
   }

}
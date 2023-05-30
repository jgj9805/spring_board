package board;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BoardDTO {
	
	   private int num;
	   private String userid;
	   private String userpass;
	   private String username;
	   private String listtitle;
	   private String content;
	   private String listdate;
	   private int viewnum;
	   
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getListtitle() {
		return listtitle;
	}
	public void setListtitle(String listtitle) {
		this.listtitle = listtitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getListdate() {
		return listdate;
	}
	public void setListdate() {
		Date today = new Date();
		Locale currentLocale = new Locale("KOREAN", "KOREA");
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat  formatter = new SimpleDateFormat(pattern, currentLocale);
		this.listdate=formatter.format(today);
	}
	public void setListdate(String listdate) {
		this.listdate = listdate;
	}
	public int getViewnum() {
		return viewnum;
	}
	public void setViewnum(int viewnum) {
		this.viewnum = viewnum;
	}

	   
	   
	   
}


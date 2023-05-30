package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class BoardDDL {

    public boolean insert(BoardDTO dto) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	int flag = 0;
    	try {
    		//conn = DBConnect.initConnection();  //Connection 객체에서 conn 받아오기
    		conn = new DBConnect().getConn();
    		
    		String query = "insert into bbslist"
    				       + "(userid, userpass, username, listtitle, content)"
    				       + "values"
    				       + "(?,?,?,?,?)";
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, dto.getUserid());
    		pstmt.setString(2, dto.getUserpass());
    		pstmt.setString(3, dto.getUsername());
    		pstmt.setString(4, dto.getListtitle());
    		pstmt.setString(5, dto.getContent());

    		flag = pstmt.executeUpdate();
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		try { 
    			if(pstmt != null) pstmt.close(); 
    		    if(conn != null) conn.close();
    		}catch(SQLException e) {}
    	}
    	if(flag > 0) { //성공
    		return true;
    	}else {  //실패
    		return false;
    	}
    }
    
    
    //AllSelect
    public static int getAllSelect() {
    	Connection conn = null;
    	Statement st = null;
    	ResultSet rs = null;
    	String sql = null;
    	int allCount = 0;
    	sql = "select count(*) from bbslist";
    	try {
    		conn = new DBConnect().getConn();
    		st = conn.createStatement();
    		rs = st.executeQuery(sql);
    		while(rs.next()) {
    			allCount = rs.getInt(1);
    		}
    	}catch(SQLException e){
    		
    	}finally {
     	   try { 
   	    	if(rs != null) rs.close();
   		    if(st != null) st.close(); 
   	         if(conn != null) conn.close();
   	    }catch(SQLException e) {}
   	}
    	return allCount;
    }
    
    
    //select
    public static Vector<BoardDTO> getSelect(String str) {
    	Connection conn = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	String sql = null;
    	sql = "select * from bbslist where num=?";
    	Vector<BoardDTO> data = new Vector<>();
    	conn = new DBConnect().getConn();
    	try {
    	  ps = conn.prepareStatement(sql);
    	  ps.setString(1, str);
   
    	  //System.out.println(ps);
    	  rs = ps.executeQuery();

     	  while(rs.next()) {
    			BoardDTO mb = new BoardDTO();
      			mb.setNum(rs.getInt("num"));
      			mb.setUserid(rs.getString("userid"));
      			mb.setUserid(rs.getString("userpass"));
      			mb.setUsername(rs.getString("username"));
      			mb.setListtitle(rs.getString("listtitle"));
      			mb.setContent(rs.getString("content"));
      			mb.setListdate(rs.getString("listdate"));
      			mb.setViewnum(rs.getInt("listNum"));
    			data.add(mb);
    	 }

    	}catch(SQLException e) {}
    	finally {
    	   try { 
    	    	if(rs != null) rs.close();
    		    if(ps != null) ps.close(); 
    	         if(conn != null) conn.close();
    	    }catch(SQLException e) {}
    	}
    	return data;
    }
    
    public static Vector<BoardDTO> getSelect(int limitNum, int listNum) {
    	Connection conn = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	String sql = null;

    	sql = "select * from bbslist order by num desc limit ?, ?";

    	Vector<BoardDTO> data = new Vector<>();
    	conn = new DBConnect().getConn();
    	try {
    	  ps = conn.prepareStatement(sql);
    	  ps.setInt(1, limitNum);
    	  ps.setInt(2, listNum);
   
    	  //System.out.println(ps);
    	  rs = ps.executeQuery();

     	  while(rs.next()) {
  			BoardDTO mb = new BoardDTO();
  			mb.setNum(rs.getInt("num"));
  			mb.setUsername(rs.getString("username"));
  			mb.setUserid(rs.getString("userid"));
  			mb.setListtitle(rs.getString("listtitle"));
  			mb.setContent(rs.getString("content"));
  			mb.setListdate(rs.getString("listdate"));
  			mb.setViewnum(rs.getInt("viewnum"));

  			data.add(mb);
    	 }

    	}catch(SQLException e) {}
    	finally {
    	   try { 
    	    	if(rs != null) rs.close();
    		    if(ps != null) ps.close(); 
    	         if(conn != null) conn.close();
    	    }catch(SQLException e) {}
    	}
    	return data;
    }
    
    //cboard select
    public static Vector<BoardDTO> BoardSelect(int str1) {
    	Connection conn = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	String sql = null;
    	sql = "select * from bbslist where num=?";
    	Vector<BoardDTO> data = new Vector<>();
    	conn = new DBConnect().getConn();
    	try {
    	  ps = conn.prepareStatement(sql);
    	  ps.setInt(1, str1);


    	  //System.out.println(ps);
    	  rs = ps.executeQuery();

     	  while(rs.next()) {
    			BoardDTO mb = new BoardDTO();
    			mb.setNum(rs.getInt("num"));
    			mb.setListtitle(rs.getString("listtitle"));
      			mb.setUsername(rs.getString("username"));
      			mb.setUserid(rs.getString("userid"));
      			mb.setListdate(rs.getString("listdate"));
      			mb.setContent(rs.getString("content"));
    			data.add(mb);
    	 }

    	}catch(SQLException e) {}
    	finally {
    	   try { 
    	    	if(rs != null) rs.close();
    		    if(ps != null) ps.close(); 
    	         if(conn != null) conn.close();
    	    }catch(SQLException e) {}
    	}
    	return data;
    }


    public boolean update(BoardDTO dto) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	int flag = 0;
    	try {
    		conn = new DBConnect().getConn();
    		String query = "";
    	
    			query = "update bbslist set username=?, listtitle=?, content=?, listdate=? where num=?";	  		  
    			pstmt = conn.prepareStatement(query);
        		pstmt.setString(1, dto.getUsername());
        		pstmt.setString(2, dto.getListtitle());
        		pstmt.setString(3, dto.getContent());
        		pstmt.setString(4, dto.getListdate());
        		pstmt.setInt(5, dto.getNum());
  

    		flag = pstmt.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		try { 
    			if(pstmt != null) pstmt.close(); 
    		    if(conn != null) conn.close();
    		}catch(SQLException e) {}
    	}
    	if(flag > 0) { //성공
    		return true;
    	}else {  //실패
    		return false;
    	}
    }

    //delete
    public boolean delete(BoardDTO dto) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	int flag = 0;
    	try {
    		conn = new DBConnect().getConn();
    		String query = "";
    	
    			query = "delete from bbslist where num=?";	  		  
    			pstmt = conn.prepareStatement(query);
        		pstmt.setInt(1, dto.getNum());


    		flag = pstmt.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		try { 
    			if(pstmt != null) pstmt.close(); 
    		    if(conn != null) conn.close();
    		}catch(SQLException e) {}
    	}
    	if(flag > 0) { //성공
    		return true;
    	}else {  //실패
    		return false;
    	}
    }
}



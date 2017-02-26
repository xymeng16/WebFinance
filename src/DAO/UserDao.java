package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




import entity.UserInfo;
import util.DBhelper;

public class UserDao {

	public static boolean InsertInfo(String username, String password, String Email) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean flag = false;
//		System.out.println(username);
//		System.out.println(password);
//		System.out.println(Email);
		try {
			conn = DBhelper.getConnection();
			String sql =" insert into user values (0,'"+Email+"', '"+password+"','"+username+"',null) ";
			stmt = conn.prepareStatement(sql);
	        flag = stmt.execute();
	   
	        return flag;
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return flag;
		
	}
	public static boolean Findusername(String username){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		try {
			conn = DBhelper.getConnection();
			String sql =" select * from user where USERNAME = '"+username+"' ";
			stmt = conn.prepareStatement(sql);
			
	        rs = stmt.executeQuery();
	        if (rs.next()){
	        	return false;
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return true;
	}
	
	public static boolean FindEmail(String Email){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBhelper.getConnection();
			String sql =" select * from user where EMAIL ='"+Email+"'  ";
			stmt = conn.prepareStatement(sql);
	        rs = stmt.executeQuery();
	        if (rs.next() ){
	        	return false;
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return true;
	}
	public static boolean Check(String password, String repassword) {
	    if (password.equals(repassword)){
		return true;
	    }
	    else return false;
	}
   public static String user_pass(String username){
	   Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String outcome = null;
		try {
			conn = DBhelper.getConnection();
			String sql =" select * from user where USERNAME ='"+username+"'  ";
			stmt = conn.prepareStatement(sql);
	        rs = stmt.executeQuery();
	        if (rs.next() ){
	        	outcome = rs.getString("PASSWORD");
	        	return outcome;
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outcome;
   }
   public static int getProperty(String username){
	   Connection conn = null;
	 		PreparedStatement stmt = null;
	 		ResultSet rs = null;
	 		int outcome = 0 ;
	 		try {
	 			conn = DBhelper.getConnection();
	 			String sql =" select * from user where USERNAME ='"+username+"'  ";
	 			stmt = conn.prepareStatement(sql);
	 	        rs = stmt.executeQuery();
	 	        if (rs.next() ){
	 	        	outcome = rs.getInt("property");
	 	        	return outcome;
	 	        }
	 	        
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}
	 		return outcome;
   }
   public static int payProperty(String username,int i){
	   Connection conn = null;
	 		PreparedStatement stmt = null;
	 		ResultSet rs = null;
	 		int outcome = 0 ;
	 		try {
	 			conn = DBhelper.getConnection();
	 			String sql =" select * from user where USERNAME ='"+username+"'  ";
	 			stmt = conn.prepareStatement(sql);
	 	        rs = stmt.executeQuery();
	 	        if (rs.next() ){
	 	        	outcome = rs.getInt("property");
	 	        	outcome = outcome + i;
	 	        	System.out.println(outcome);
	 	        }
	 	        sql =" update user set PROPERTY = ? where USERNAME = '"+username+"' ";
	 	        stmt = conn.prepareStatement(sql);
	 	        stmt.setInt(1, outcome);
	 	       stmt.execute();
	 	        return outcome;
	 	        
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}
	 		return outcome;
   }
   public static int withdrawProperty(String username,int i){
	   Connection conn = null;
	 		PreparedStatement stmt = null;
	 		ResultSet rs = null;
	 		int outcome = 0 ;
	 		try {
	 			conn = DBhelper.getConnection();
	 			String sql =" select * from user where USERNAME ='"+username+"'  ";
	 			stmt = conn.prepareStatement(sql);
	 	        rs = stmt.executeQuery();
	 	        if (rs.next() ){
	 	        	outcome = rs.getInt("property");
	 	        	outcome = outcome - i;
	 	        	System.out.println(outcome);
	 	        }
	 	        sql =" update user set PROPERTY = ? where USERNAME = '"+username+"' ";
	 	        stmt = conn.prepareStatement(sql);
	 	        stmt.setInt(1, outcome);
	 	       stmt.execute();
	 	        return outcome;
	 	        
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}
	 		return outcome;
   }
	
}

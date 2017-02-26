package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




import entity.DetailWork;
import util.DBhelper;
public class DetailWorkDao {
	public static boolean InsertInfo(String username,
	String work,
	String workplace,
	String income,
	String workplacephone,
	String linkman,
	String linkmanphone
	) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean flag = false;
//		System.out.println(username);
//		System.out.println(password);
//		System.out.println(Email);
		try {
			conn = DBhelper.getConnection();
			String sql =" insert into detailwork values ('"+username+"', '"+work+"','"+workplace+"','"+income+"','"+workplacephone+"','"+linkman+"','"+linkmanphone+"',null) ";
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
			String sql =" select * from detailwork where USERNAME = '"+username+"' ";
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
}
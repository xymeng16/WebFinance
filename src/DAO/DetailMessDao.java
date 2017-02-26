package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




import entity.DetailMess;
import entity.ToBorrow;
import util.DBhelper;
public class DetailMessDao {
	public static boolean InsertInfo(String username,
	String name,
	String idcard,
	String idcardfile,
	int age,
	String ismerried,
	String ishouse,
	String housefile,
	String iscar,
	String phone,
	String address,
	String tradepass) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean flag = false;
//		System.out.println(username);
//		System.out.println(password);
//		System.out.println(Email);
		try {
			conn = DBhelper.getConnection();
			String sql =" insert into detailmess values ('"+username+"', '"+name+"','"+idcard+"','"+idcardfile+"',?,'"+ismerried+"','"+ishouse+"','"+housefile+"','"+iscar+"','"+phone+"','"+address+"','"+tradepass+"',null) ";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, age);
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
			String sql =" select * from detailmess where USERNAME = '"+username+"' ";
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
	public static DetailMess getByUser(String username ){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		DetailMess dm = new DetailMess();
		try {
			conn = DBhelper.getConnection();
			String sql =" select * from detailmess where USERNAME = ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,username);
	        rs = stmt.executeQuery();
	        if(rs.next()){
	        dm.setHousefile(rs.getString("HOUSEFILE"));
	        dm.setIdcardfile(rs.getString("IDCARDFILE"));
	        }
	       return dm;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return dm;
	}
}

package DAO;
import java.sql.Connection;
import entity.ToBorrow;
import entity.Record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;

import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.NEW;







import entity.ToBorrow;
import util.DBhelper;
public class ToBorrowDao {
	public static boolean InsertInfo(String username,
	String title,
	String rate,
	String target,
	String calculationway,
	String waytoback,
	String  time,
	String  description,
	String  institution
	) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean flag = false;
//		System.out.println(username);
//		System.out.println(password);
//		System.out.println(Email);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
	    
		try {
			conn = DBhelper.getConnection();
			String sql =" insert into toborrow values (null,'"+username+"', '"+title+"','"+rate+"','"+target+"','"+calculationway+"','"+waytoback+"','"+time+"','"+description+"','"+institution+"','"+sdf.format(date)+"','"+sdf.format(new Date(date.getTime()+Integer.parseInt(time)*24*60*60*1000))+"') ";
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
			String sql =" select * from toborrow where USERNAME = '"+username+"' ";
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
	public static List<Map<String,Object>> getResult(int currentPage){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Map<String,Object>> list =new ArrayList<Map<String,Object>>();
		try {
			conn = DBhelper.getConnection();
			String sql =" select * from toborrow order by id desc limit ?,3 ";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, (currentPage-1)*3);
	        rs = stmt.executeQuery();
	         ResultSetMetaData metaData =rs.getMetaData();
	 	    int cols_len=metaData.getColumnCount();
	 	   while(rs.next()){
	 		   Map<String,Object> map = new HashMap<String,Object>();
	 		   for (int i =0;i<cols_len;i++){
	 			   String cols_name = metaData.getColumnName(i+1);
	 			   Object cols_value =rs.getObject(cols_name);
	 			   if (cols_value==null){
	 				   cols_value="";
	 			   }
	 			   map.put(cols_name, cols_value);
	 		   }
	 		   list.add(map);
	 		   
	 	   }
	 	   return list;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public static ToBorrow getById(int id ){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ToBorrow tb = new ToBorrow();
		try {
			conn = DBhelper.getConnection();
			String sql =" select * from toborrow where ID = ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,id);
	        rs = stmt.executeQuery();
	       if (rs.next()){
	        tb.setCalculationway(rs.getString("CALCULATIONWAY"));
	       
	        tb.setDescription(rs.getString("DESCRIPTION"));
	        tb.setId(id);
	        tb.setInstitution(rs.getString("INSTITUTION"));
	        tb.setRate(rs.getString("Rate"));
	        tb.setTarget(rs.getString("TARGET"));
	        tb.setTime(rs.getString("TIME"));
	        tb.setTitle(rs.getString("TITLE"));
	        tb.setUsername(rs.getString("USERNAME"));
	        tb.setWaytoback(rs.getString("WAYTOBACK"));
	        tb.setDate(rs.getString("DATE"));
	        tb.setEnddate(rs.getString("ENDDATE"));
	       }
	        return tb;
	}catch (Exception e) {
		// TODO: handle exception
	}
		return tb;
}
	public static void createByUser(String username){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		try {
			conn = DBhelper.getConnection();
			String sql ="create table ? (USERNAME varchar(30), AMOUNT varchar(20), DATE datetime, ID int auto_increment ,PRIMARY KEY(ID) )";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,username);
	        rs = stmt.executeQuery();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
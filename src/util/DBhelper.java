package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBhelper {

	private static final String url ="jdbc:mysql://127.0.0.1/test";
    private static final String name = "com.mysql.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "root";
    private static Connection conn = null;
    static {
    	try {
			Class.forName(name);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static Connection getConnection() throws Exception{
    	if (conn == null){
    		conn = DriverManager.getConnection(url,username,password);
    		return conn;
    	}
    	return conn;
    }
    
    public static void main(String[] args){
    	Connection conn;
		try {
			conn = DBhelper.getConnection();
			if (conn!=null){
	    		System.out.println("sss");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
}

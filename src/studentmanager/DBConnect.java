package studentmanager;


/*数据库连接类*/

import java.sql.*;

public class DBConnect{
	
	public static Connection getConn() throws Exception{
		
		String driver="com.mysql.jdbc.Driver";
	
		String url="jdbc:mysql://127.0.0.1:3307/studentsmanager?useSSL=false";
		
		String user="u1";
		
		String passwd="000000";
		Class.forName(driver);
	
		Connection conn=DriverManager.getConnection(url,user,passwd);
		return conn;
}
}
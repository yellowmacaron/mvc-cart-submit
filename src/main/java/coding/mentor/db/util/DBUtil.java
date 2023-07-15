package coding.mentor.db.util;

import java.sql.DriverManager;
import java.sql.Connection;


public class DBUtil {
	public static Connection makeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/be4","root","221197");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

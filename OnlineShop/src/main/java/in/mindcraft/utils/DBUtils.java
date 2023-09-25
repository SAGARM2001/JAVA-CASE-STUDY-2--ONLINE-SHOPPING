package in.mindcraft.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection cn;

	public static Connection openConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost/onlineshop";
		cn = DriverManager.getConnection(url, "root", "Sagar@2001");
		return cn;
	}

	public static void closeConnection() throws SQLException {
		if (cn != null)
			cn.close();
	}
}

package com.revature.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		String url = System.getenv("JDBC_URL");
		String username = "postgres";
		String password = System.getenv("JDBC_PASSWORD");
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}

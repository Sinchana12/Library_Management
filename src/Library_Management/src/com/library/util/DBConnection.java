package com.library.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static final String url="jdbc:mysql://localhost:3306/LibraryDB";
	private static final String username="root";
	private static final String password="MySQL";
	private static Connection connection;

	public static Connection getConnection() {
		try {
			if(connection== null || connection.isClosed() ) {
				connection= DriverManager.getConnection(url,username,password);
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error");
		}
		return connection;
	}
	
	public static void closeConnection() {
		try {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

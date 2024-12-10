package com.library.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static final String url="jdbc:mysql://localhost:3306/LibraryDB";
	private static final String username="root";
	private static final String password="MySQL";
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error");
		}
	}
}

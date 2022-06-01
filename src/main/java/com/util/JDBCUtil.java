package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	private static String DB_DRIVER = "org.postgresql.Driver";
	private static String DB_URL = "jdbc:postgresql://localhost:5432/gmail";
	private static String DB_USER = "postgres";
	private static String DB_PASSWORD = "root";
	
	public static Connection getConnection() {
		try {
			Class.forName(DB_DRIVER);
		}catch(ClassNotFoundException e) {
			System.out.println("Class Not Found "+e.getMessage());
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		}catch(SQLException e) {
			System.out.println("Connection Errore"+e.getMessage());
		}if(connection != null) {
			System.out.println("Connection is up and running");
		}else {
			System.out.println("Connection is null");
		}return connection;
	}
}

package com.gmail.fomenkoc.store.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnetcion {
	private static String USER_NAME;
	private static String PASSWORD;
	private static final String URL = 
						"jdbc:mysql://localhost:3306/Store?serverTimezone=UTC";

	public static Connection getConnection(String userName, String password)
														throws SQLException {
		USER_NAME = userName;
		PASSWORD = password;

		return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
	}
}

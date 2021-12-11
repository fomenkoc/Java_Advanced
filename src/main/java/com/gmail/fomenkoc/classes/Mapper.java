package com.gmail.fomenkoc.classes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Mapper {

	public static User user(ResultSet rs) {
		try {
			int userID = rs.getInt("UserID");
			String userName = rs.getString("UserName");
			String email = rs.getString("Email");
			boolean isAdmin = rs.getBoolean("IsAdmin");
			String password = rs.getString("Password");
			return new User(userID, userName, email, isAdmin, password);
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

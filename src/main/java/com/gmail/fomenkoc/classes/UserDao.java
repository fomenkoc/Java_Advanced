package com.gmail.fomenkoc.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
	private static final String READ_ALL = "SELECT * " 
										 + "FROM r_Users ";

	private static final String CREATE = 
					"INSERT INTO r_Users(UserName, Email, IsAdmin, Password) "
				  + "VALUES(?, ?, ?, ?) ";

	private static final String READ = "SELECT * " 
									 + "FROM r_Users "
									 + "WHERE Email = ? ";

	private static final String UPDATE = 
					"UPDATE r_Users "
				  + "SET UserName = ?, Email = ?, IsAdmin = ?, Password = ? " 
			      + "WHERE UserID = ? ";

	private static final String DELETE = "DELETE " 
									   + "FROM r_Users "
									   + "WHERE UserID = ? ";
	
	private static final String LOGIN = "SELECT * " 
			 						  + "FROM r_Users "
			 						  + "WHERE Email = ? AND Password LIKE ?";

	private Connection conn;
	private PreparedStatement ps;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public UserDao() {
		super();
		this.conn = DBConnetcion.getConnection();
	}

	public ArrayList<User> readAll() throws SQLException {
		ps = conn.prepareStatement(READ_ALL);
		ResultSet rs = ps.executeQuery();
		ArrayList<User> users = new ArrayList<User>();
		while(rs.next()) {
			users.add(Mapper.user(rs));
		}
		return users;
	}
	
	public void create(User user) throws SQLException {
		ps = conn.prepareStatement(CREATE);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getEmail());
		ps.setBoolean(3, user.isAdmin());
		ps.setString(4, user.getPassword());
		ps.executeUpdate();
	}
	
	public User read(User user) throws SQLException {
		ps = conn.prepareStatement(READ);
		ps.setString(1, user.getEmail());
		ResultSet rs = ps.executeQuery();
		rs.next();
		return Mapper.user(rs);
	}
	
	public void update(User user) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getEmail());
		ps.setBoolean(3, user.isAdmin());
		ps.setString(4, user.getPassword());
		ps.setInt(5, user.getUserID());
		ps.executeUpdate();
	}
	
	public void delete(User user) throws SQLException {
		ps = conn.prepareStatement(DELETE);
		ps.setInt(1, user.getUserID());
		ps.executeUpdate();
	}
	
	public User login(String email, String password) throws SQLException {
		ps = conn.prepareStatement(LOGIN);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return Mapper.user(rs);
		} else {
			return null;
		}
	}
}

package com.gmail.fomenkoc.store.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
	private static final String READ_ALL = "SELECT * " 
										 + "FROM r_Users ";

	private static final String CREATE = 
									"INSERT INTO r_Users(UserName, IsAdmin) "
								  + "VALUES(?, ?) ";

	private static final String READ = "SELECT * " 
									 + "FROM r_Users "
									 + "WHERE UserID = ? ";

	private static final String UPDATE = "UPDATE r_Users "
									   + "SET UserName = ?, IsAdmin = ? " 
									   + "WHERE UserID = ? ";

	private static final String DELETE = "DELETE " 
									   + "FROM r_Users "
									   + "WHERE UserID = ? ";

	private Connection conn;
	private PreparedStatement ps;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
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
		ps.setBoolean(2, user.isAdmin());
		ps.executeUpdate();
	}
	
	public User read(User user) throws SQLException {
		ps = conn.prepareStatement(READ);
		ps.setInt(1, user.getUserID());
		ResultSet rs = ps.executeQuery();
		rs.next();
		return Mapper.user(rs);
	}
	
	public void update(User user) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		ps.setString(1, user.getUserName());
		ps.setBoolean(2, user.isAdmin());
		ps.setInt(3, user.getUserID());
		ps.executeUpdate();
	}
	
	public void delete(User user) throws SQLException {
		ps = conn.prepareStatement(DELETE);
		ps.setInt(1, user.getUserID());
		ps.executeUpdate();
	}
}

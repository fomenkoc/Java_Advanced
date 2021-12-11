package com.gmail.fomenkoc.classes;

public class User {

	private int userID;
	private String userName;
	private String email;
	private boolean isAdmin;
	private String password;

	public User(int userID, String userName, String email, boolean isAdmin,
			String password) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.email = email;
		this.isAdmin = isAdmin;
		this.password = password;
	}

	public User(String userName, String email, boolean isAdmin,
			String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.isAdmin = isAdmin;
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", email="
				+ email + ", isAdmin=" + isAdmin + ", password=" + password
				+ "]";
	}

	
	
}

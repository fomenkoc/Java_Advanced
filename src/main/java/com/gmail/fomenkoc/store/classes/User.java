package com.gmail.fomenkoc.store.classes;

public class User {
	private int userID;
	private String userName;
	private boolean isAdmin;

	public User(int userID, String userName, boolean isAdmin) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.isAdmin = isAdmin;
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName
				+ ", isAdmin=" + isAdmin + "]";
	}

}

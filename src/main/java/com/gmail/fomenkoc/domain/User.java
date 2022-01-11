package com.gmail.fomenkoc.domain;

import java.util.Objects;

public class User {
	private Integer userID;
	private String email;
	private String firstName;
	private String lastNmae;
	private Integer roleID;
	private String password;

	public User(Integer userID, String email, String firstName, String lastNmae,
			Integer roleID, String password) {
		super();
		this.userID = userID;
		this.email = email;
		this.firstName = firstName;
		this.lastNmae = lastNmae;
		this.roleID = roleID;
		this.password = password;
	}

	public User(String email, String firstName, String lastNmae, Integer roleID,
			String password) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastNmae = lastNmae;
		this.roleID = roleID;
		this.password = password;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNmae() {
		return lastNmae;
	}

	public void setLastNmae(String lastNmae) {
		this.lastNmae = lastNmae;
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, lastNmae, password, roleID,
				userID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastNmae, other.lastNmae)
				&& Objects.equals(password, other.password)
				&& Objects.equals(roleID, other.roleID)
				&& Objects.equals(userID, other.userID);
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", email=" + email + ", firstName="
				+ firstName + ", lastNmae=" + lastNmae + ", roleID=" + roleID
				+ ", password=" + password + "]";
	}

}

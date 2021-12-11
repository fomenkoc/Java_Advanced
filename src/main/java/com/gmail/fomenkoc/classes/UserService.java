package com.gmail.fomenkoc.classes;

import java.util.ArrayList;

public class UserService {
	private ArrayList<User> listOfUsers = new ArrayList<>();
	private static UserService userService;

	private UserService() {
		listOfUsers
				.add(new User(1, "Admin", "admin@magazines.ua", true, "12345"));
		
	}

	public static UserService getUserService() {
		if (userService == null) {
			userService = new UserService();

		}
		return userService;
	}

	public ArrayList<User> getListOfUsers() {
		return listOfUsers;
	}

	public void saveUser(User user) {
		listOfUsers.add(user);
	}

	public User getUser(String email) {
		return listOfUsers.stream()
				.filter(user -> user.getEmail().equals(email)).findAny()
				.orElse(null);
	}

}

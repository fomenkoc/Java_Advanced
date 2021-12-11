package com.gmail.fomenkoc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmail.fomenkoc.classes.User;
import com.gmail.fomenkoc.classes.UserDao;

@WebServlet(name = "registration", urlPatterns = { "/registration" })
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String userName;
	private String email;
	private String password;
	private String rePassword;
	private User user;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		this.userName = req.getParameter("userName");
		this.email = req.getParameter("email");
		this.password = req.getParameter("password");
		this.rePassword = req.getParameter("rePassword");

		UserDao userDao = new UserDao();
		ArrayList<User> users = new ArrayList<>();
		try {
			users = userDao.readAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (users.stream()
				.filter(user -> user.getEmail().equalsIgnoreCase(email))
				.findAny().orElse(null) == null
				&& 
			users.stream().filter(user -> user.getUserName()
				.equalsIgnoreCase(userName)).findAny().orElse(null) == null 
				&& 
				password.equals(rePassword) ) {

			this.user = new User(userName, email, false, password);
			try {
				userDao.create(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.setAttribute("userName", user.getUserName());
			req.getRequestDispatcher("welcome.jsp").forward(req, resp);
		} else {
			System.out.println(
					"User already exists or incorrect retype password");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}

}

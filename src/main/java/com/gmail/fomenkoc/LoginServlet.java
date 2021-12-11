package com.gmail.fomenkoc;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmail.fomenkoc.classes.User;
import com.gmail.fomenkoc.classes.UserDao;

@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	private User user;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		this.email = req.getParameter("email");
		this.password = req.getParameter("password");

		UserDao userDao = new UserDao();

		try {
			this.user = userDao.login(email, password);
		} catch (SQLException e) {
			
		}

		if (this.user != null && this.user.getPassword().equals(password)) {
			req.setAttribute("userName", user.getUserName());
			req.getRequestDispatcher("welcome.jsp").forward(req, resp);
		} else {
			System.out.println("Incorrect Email OR Password");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}

}

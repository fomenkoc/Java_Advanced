package com.gmail.fomenkoc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.gmail.fomenkoc.dao.impl.UserDao;
import com.gmail.fomenkoc.domain.User;

@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = Logger.getLogger(LoginServlet.class);
	
	private String email;
	private String password;
	private User user;


	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		UserDao userDao = new UserDao();
		this.email = req.getParameter("email");
		this.password = req.getParameter("password");
		this.user = userDao.login(email, password);

		if (this.user != null
				&& this.password.equals(this.user.getPassword())) {
			req.setAttribute("firstName", this.user.getFirstName());
			req.setAttribute("lastName", this.user.getLastNmae());
			req.setAttribute("email", this.user.getEmail());
			req.getRequestDispatcher("welcome.jsp").forward(req, resp);
		} else {

			LOG.warn("Incorrect Email OR Password");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}

}

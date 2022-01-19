package com.gmail.fomenkoc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gmail.fomenkoc.dao.impl.UserDao;
import com.gmail.fomenkoc.domain.User;
import com.google.gson.Gson;

@WebServlet(name = "user", urlPatterns = { "/user" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		UserDao userDao = new UserDao();
		User user;
		Integer userID;
		HttpSession session = request.getSession();
		userID = Integer.parseInt(session.getAttribute("userID").toString());
		user = userDao.read(userID);
		
		String json = new Gson().toJson(user);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		

		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}

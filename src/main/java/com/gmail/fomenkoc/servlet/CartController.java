package com.gmail.fomenkoc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gmail.fomenkoc.dao.impl.CartDao;
import com.gmail.fomenkoc.domain.Cart;


@WebServlet(name = "cart", urlPatterns = { "/cart" })
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartDao cartDao = new CartDao();
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Integer prodID = Integer.parseInt(request.getParameter("prodID"));
		HttpSession session = request.getSession();
		Integer userID = (Integer) session.getAttribute("userID");
		
		Cart cart = new Cart(userID, prodID);
		cartDao.create(cart);
		
		response.setContentType("test");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

}

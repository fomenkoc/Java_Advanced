package com.gmail.fomenkoc.utils;

import java.util.ArrayList;
import java.util.List;

import com.gmail.fomenkoc.dao.impl.CartDao;
import com.gmail.fomenkoc.dao.impl.ProdDao;
import com.gmail.fomenkoc.dao.impl.RoleDao;
import com.gmail.fomenkoc.dao.impl.UserDao;
import com.gmail.fomenkoc.domain.Cart;
import com.gmail.fomenkoc.domain.Prod;
import com.gmail.fomenkoc.domain.Role;
import com.gmail.fomenkoc.domain.User;

public class FillDB {
	public static void run() {
		RoleDao roleDao = new RoleDao();
		UserDao userDao = new UserDao();
		ProdDao prodDao = new ProdDao();
		CartDao cartDao = new CartDao();

		List<Prod> prods = new ArrayList<Prod>();
		List<User> users = new ArrayList<User>();
		List<Cart> carts = new ArrayList<Cart>();

		if (roleDao.readAll().size() == 0) {
			Role roleAdmin = new Role("Administrator", true);
			Role roleCoustomer = new Role("Coustomer", false);
			roleDao.create(roleAdmin);
			roleDao.create(roleCoustomer);

		}

		if (userDao.readAll().size() == 0) {
			User userAdmin = new User("admin@gmail.com", "Admin",
					"Administrator", roleDao.read(1), "Qwe123456");
			User userCoustomer = new User("test_coustomer@gmail.com", "Test",
					"Coustomer", roleDao.read(2), "Qwe123456");
			userDao.create(userAdmin);
			userDao.create(userCoustomer);
		}

		if (prodDao.readAll().size() == 0) {
			String prodName = "Тестове видання";
			String description = "Опис";
			Double price = 5.25;
			for (int i = 1; i <= 50; i++) {
				prods.add(new Prod(prodName + " " + String.valueOf(i),
						description, price * i));
			}
			for (Prod prod : prods) {
				prodDao.create(prod);
			}

			prods = prodDao.readAll();
			users = userDao.readAll();
			for (User user : users) {
				for (Prod prod : prods) {
					carts.add(new Cart(user, prod, prod.getPrice(), 1.0,
							prod.getPrice()));
				}
			}
			for (Cart cart : carts) {
				cartDao.create(cart);
			}
		}
	}

}

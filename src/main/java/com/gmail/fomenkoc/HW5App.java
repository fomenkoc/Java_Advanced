package com.gmail.fomenkoc;

import java.sql.Timestamp;

import com.gmail.fomenkoc.dao.impl.*;
import com.gmail.fomenkoc.domain.*;

public class HW5App {

	public static void main(String[] args) {
		RoleDao roleDao = new RoleDao();
		Role role = new Role("Administrator");
		roleDao.create(role);
		role = new Role("Customer");
		roleDao.create(role);
		role = new Role("testRole");
		roleDao.create(role);
		
		System.out.println(roleDao.readAll());
		System.out.println();
		role = roleDao.read(3);
		role.setRoleName("UpdatedRole");
		roleDao.update(role);
		System.out.println(roleDao.readAll());
		System.out.println();
		roleDao.delete(3);
		System.out.println(roleDao.readAll());
		System.out.println();
		
		
		UserDao userDao = new UserDao();
		User user = new User("admin@gmail.com", "Admin", "Admin", 1, "12345");
		userDao.create(user);
		user = new User("customer1@gmail.com", "CustomerName", "Customer", 2, "12345");
		userDao.create(user);
		
		System.out.println(userDao.readAll());
		System.out.println();
		
		ProdDao prodDao = new ProdDao();
		Prod prod = new Prod("Product 1", "", 123.55);
		prodDao.create(prod);
		prod = new Prod("Product 2", "", 123.55);
		prodDao.create(prod);
		prod = new Prod("Product 3", "", 123.55);
		prodDao.create(prod);
		prod = new Prod("Product 4", "", 123.55);
		prodDao.create(prod);
		prod = new Prod("Product 5", "", 123.55);
		prodDao.create(prod);
		
		System.out.println(prodDao.readAll());
		System.out.println();
		
		OrderHeadDao headDao = new OrderHeadDao();
		OrderDetailsDao detailsDao = new OrderDetailsDao();
		
		OrderHead orderHead = new OrderHead(
				new Timestamp(System.currentTimeMillis()), "", "", 2, 0.0, 0.0);
		
		orderHead = headDao.create(orderHead);
		Integer orderID = orderHead.getOrderID();
		OrderDetails orderDetails = new OrderDetails(orderID, 1, 1.0, 123.55, 123.55);
		detailsDao.create(orderDetails);
		orderDetails = new OrderDetails(orderID, 2, 1.0, 123.55, 123.55);
		detailsDao.create(orderDetails);
		orderDetails = new OrderDetails(orderID, 3, 1.0, 123.55, 123.55);
		detailsDao.create(orderDetails);
		
		
		
		orderHead = headDao.read(orderID);
		
		System.out.println(orderHead);

	}

}

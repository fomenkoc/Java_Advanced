package com.gmail.fomenkoc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Application {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Cart cart = new Cart(1.0, "Cart 1");
		session.persist(cart);
		Item item1 = new Item(1.0);
		Item item2 = new Item(2.0);
		Item item3 = new Item(3.0);
		Item item4 = new Item(4.0);

		Cart updCart = session.get(Cart.class, 1);
		Set<Item> items = new HashSet<>(
					Arrays.asList(item1, item2, item3, item4));

		updCart.setItems(items);

		session.persist(updCart);

		transaction.commit();

		session.close();

	}

}

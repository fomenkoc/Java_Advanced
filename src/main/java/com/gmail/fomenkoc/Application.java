package com.gmail.fomenkoc;

import java.util.HashSet;

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

		Post post = new Post("Dogs flew to the moon", new HashSet<Comment>());
		post.getComments().add(new Comment("NASA", post));
		post.getComments().add(new Comment("Astronaut Wolowitz", post));
		post.getComments().add(new Comment("Raj Koothrappali", post));

		session.save(post);

		transaction.commit();

		Post readPost = session.get(Post.class, 1);
		System.out.println(readPost);
		System.out.println(readPost.getComments());

		System.out.println();

		Comment readComment = session.get(Comment.class, 1);
		System.out.println(readComment);
		System.out.println(readComment.getPost());

		session.close();

	}

}

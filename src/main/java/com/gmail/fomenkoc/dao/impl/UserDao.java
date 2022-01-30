package com.gmail.fomenkoc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.gmail.fomenkoc.dao.UserDaoInterface;
import com.gmail.fomenkoc.domain.User;
import com.gmail.fomenkoc.shared.FactoryManager;

public class UserDao implements UserDaoInterface {

	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public User create(User user) {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User read(Integer id) {
		User user = null;
		try {
			em.getTransaction().begin();
			user = em.find(User.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User update(User user) {
		try {
			em.getTransaction().begin();
			User tmpUser = em.find(User.class, user.getUserID());
			tmpUser.setEmail(user.getEmail());
			tmpUser.setFirstName(user.getFirstName());
			tmpUser.setLastName(user.getLastName());
			tmpUser.setPassword(user.getPassword());
			tmpUser.setRole(user.getRole());
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void delete(Integer id) {
		User user = read(id);
		try {
			em.getTransaction().begin();
			em.remove(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> readAll() {
		Query query = null;
		try {
			em.getTransaction().begin();
			query = em.createQuery("SELECT u FROM User u");
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Override
	public User login(String email, String password) {
		User user = null;
		try {
			em.getTransaction().begin();
			CriteriaBuilder builder = em.getCriteriaBuilder();
			em.getTransaction().commit();
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			query.select(root);
			query.where(builder.equal(root.get("email"), email));
			em.getTransaction().begin();
			TypedQuery<User> typedQuery = em.createQuery(query);
			em.getTransaction().commit();
			if (typedQuery.getSingleResult().getPassword().equals(password)) {
				user = typedQuery.getSingleResult();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}

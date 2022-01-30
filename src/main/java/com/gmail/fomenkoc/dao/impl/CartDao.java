package com.gmail.fomenkoc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.gmail.fomenkoc.dao.CartDaoInterface;
import com.gmail.fomenkoc.domain.Cart;
import com.gmail.fomenkoc.shared.FactoryManager;

public class CartDao implements CartDaoInterface {

	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Cart create(Cart cart) {
		try {
			em.getTransaction().begin();
			em.persist(cart);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}

	@Override
	public Cart read(Integer id) {
		Cart cart = null;
		try {
			em.getTransaction().begin();
			cart = em.find(Cart.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}

	@Override
	public Cart update(Cart cart) {
		try {
			em.getTransaction().begin();
			Cart tmpCart = em.find(Cart.class, cart.getCartID());
			tmpCart.setPrice(cart.getPrice());
			tmpCart.setProd(cart.getProd());
			tmpCart.setQuantity(cart.getQuantity());
			tmpCart.setSum(cart.getSum());
			tmpCart.setUser(cart.getUser());
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}

	@Override
	public void delete(Integer id) {
		Cart cart = read(id);
		try {
			em.getTransaction().begin();
			em.remove(cart);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> readAll() {
		Query query = null;
		try {
			em.getTransaction().begin();
			query = em.createQuery("SELECT c FROM Cart c");
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Override
	public List<Cart> readByUserID(Integer userID) {
		List<Cart> carts = null;
		try {
			em.getTransaction().begin();
			CriteriaBuilder builder = em.getCriteriaBuilder();
			em.getTransaction().commit();
			CriteriaQuery<Cart> query = builder.createQuery(Cart.class);
			Root<Cart> root = query.from(Cart.class);
			query.select(root);
			query.where(builder.equal(root.get("user").get("userID"), userID));
			em.getTransaction().begin();
			TypedQuery<Cart> typedQuery = em.createQuery(query);
			em.getTransaction().commit();
			carts = typedQuery.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carts;
	}

}

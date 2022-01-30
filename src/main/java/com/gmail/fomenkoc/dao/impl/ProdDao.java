package com.gmail.fomenkoc.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gmail.fomenkoc.dao.ProdDaoInterface;
import com.gmail.fomenkoc.domain.Prod;
import com.gmail.fomenkoc.shared.FactoryManager;

public class ProdDao implements ProdDaoInterface {

	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Prod create(Prod prod) {
		try {
			em.getTransaction().begin();
			em.persist(prod);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prod;
	}

	@Override
	public Prod read(Integer id) {
		Prod prod = null;
		try {
			em.getTransaction().begin();
			prod = em.find(Prod.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prod;
	}

	@Override
	public Prod update(Prod prod) {
		try {
			em.getTransaction().begin();
			Prod tmpProd = em.find(Prod.class, prod.getProdID());
			tmpProd.setDescription(prod.getDescription());
			tmpProd.setPrice(prod.getPrice());
			tmpProd.setProdName(prod.getProdName());
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prod;
	}

	@Override
	public void delete(Integer id) {
		Prod prod = read(id);
		try {
			em.getTransaction().begin();
			em.remove(prod);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prod> readAll() {
		Query query = null;
		try {
			em.getTransaction().begin();
			query = em.createQuery("SELECT p FROM Prod p");
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Override
	public Map<Integer, Prod> readAllMap() {
		return readAll().stream().collect(
				Collectors.toMap(Prod::getProdID, Function.identity()));
	}

}

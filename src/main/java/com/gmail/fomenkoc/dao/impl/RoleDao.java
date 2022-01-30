package com.gmail.fomenkoc.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gmail.fomenkoc.dao.RoleDaoInterface;
import com.gmail.fomenkoc.domain.Role;
import com.gmail.fomenkoc.shared.FactoryManager;

public class RoleDao implements RoleDaoInterface {

	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Role create(Role role) {
		try {
			em.getTransaction().begin();
			em.persist(role);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public Role read(Integer id) {
		Role role = null;
		try {
			em.getTransaction().begin();
			role = em.find(Role.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public Role update(Role role) {
		try {
			em.getTransaction().begin();
			Role tmpRole = em.find(Role.class, role.getRoleID());
			tmpRole.setRoleName(role.getRoleName());
			tmpRole.setIsStaff(role.getIsStaff());
			em.getTransaction().commit();
		} catch (Exception e) {

		}
		return role;
	}

	@Override
	public void delete(Integer id) {
		Role role = read(id);
		try {
			em.getTransaction().begin();
			em.remove(role);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> readAll() {
		Query query = null;
		try {
			em.getTransaction().begin();
			query = em.createQuery("SELECT e FROM Role e");
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> readStaff() {
		Query query = null;
		try {
			em.getTransaction().begin();
			query = em
					.createQuery("SELECT e FROM Role e WHERE e.isStaff = true");
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Override
	public Map<Integer, Role> readAllMap() {
		return readAll().stream().collect(
				Collectors.toMap(Role::getRoleID, Function.identity()));
	}

}

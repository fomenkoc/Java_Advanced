package com.gmail.fomenkoc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.gmail.fomenkoc.dao.RoleDaoInterface;
import com.gmail.fomenkoc.domain.Role;

public class RoleDao implements RoleDaoInterface {

	private static final String READ_ALL = "";
	private static final String CREATE = "";
	private static final String READ = "";
	private static final String UPDATE = "";
	private static final String DELETE = "";
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;

	private void initStatements() {
		this.ps = null;
		this.rs = null;
	}

	@Override
	public Role create(Role t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role update(Role t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Role> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

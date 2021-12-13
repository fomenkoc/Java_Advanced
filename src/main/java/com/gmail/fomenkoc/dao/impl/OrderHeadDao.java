package com.gmail.fomenkoc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.gmail.fomenkoc.dao.OrderHeadDaoInterface;
import com.gmail.fomenkoc.domain.OrderHead;

public class OrderHeadDao implements OrderHeadDaoInterface {

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
	public OrderHead create(OrderHead t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderHead read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderHead update(OrderHead t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<OrderHead> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

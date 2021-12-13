package com.gmail.fomenkoc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.gmail.fomenkoc.dao.OrderDetailsDaoInterface;
import com.gmail.fomenkoc.domain.OrderDetails;
import com.gmail.fomenkoc.utils.Mapper;


public class OrderDetailsDao implements OrderDetailsDaoInterface {

	private static final String READ_ALL = "SELECT * "
										 + "FROM order_details";
	
	private static final String CREATE = 
		  "INSERT INTO order_details (order_id, prod_id, quantity, price, sum) "
		+ "VALUES(?, ?, ?, ?)";
	
	private static final String READ = "SELECT * "
									 + "FROM order_details "
									 + "WHERE order_det_id = ?";
	
	private static final String READ_BY_ORDERID = "SELECT * "
			 									+ "FROM order_details "
			 									+ "WHERE order_id = ?";
	
	private static final String UPDATE = 
			 "UPDATE order_details "
		   + "SET order_id = ?, prod_id = ?, quantity = ?, price = ?, sum = ? "
		   + "WHERE order_det_id = ?";
	
	private static final String DELETE = "DELETE "
									   + "FROM order_details "
									   + "WHERE order_det_id = ?";
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;

	private void initStatements() {
		this.ps = null;
		this.rs = null;
	}

	@Override
	public OrderDetails create(OrderDetails orderDetails) {
		initStatements();
		try {
			this.ps = connection.prepareStatement(CREATE,
					Statement.RETURN_GENERATED_KEYS);
			this.ps.setInt(1, orderDetails.getOrderID());
			this.ps.setInt(2, orderDetails.getProdID());
			this.ps.setDouble(3, orderDetails.getQuantity());
			this.ps.setDouble(4, orderDetails.getPrice());
			this.ps.setDouble(5, orderDetails.getSum());
			this.ps.executeUpdate();
			this.rs = this.ps.getGeneratedKeys();
			orderDetails.setOrderDetID(rs.getInt("order_det_id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderDetails;
	}

	@Override
	public OrderDetails read(Integer id) {
		initStatements();
		OrderDetails orderDetails = null;
		try {
			this.ps = connection.prepareStatement(READ);
			this.ps.setInt(1, id);
			this.rs = this.ps.executeQuery();
			this.rs.next();
			orderDetails = Mapper.orderDetails(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderDetails;
	}

	@Override
	public OrderDetails update(OrderDetails orderDetails) {
		initStatements();

		try {
			this.ps = connection.prepareStatement(UPDATE);
			this.ps.setInt(1, orderDetails.getOrderID());
			this.ps.setInt(2, orderDetails.getProdID());
			this.ps.setDouble(3, orderDetails.getQuantity());
			this.ps.setDouble(4, orderDetails.getPrice());
			this.ps.setDouble(5, orderDetails.getSum());
			this.ps.setInt(6, orderDetails.getOrderDetID());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderDetails;
	}

	@Override
	public void delete(Integer id) {
		initStatements();
		try {
			this.ps = connection.prepareStatement(DELETE);
			this.ps.setInt(1, id);
			this.ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<OrderDetails> readAll() {
		initStatements();
		ArrayList<OrderDetails> details = new ArrayList<>();
		try {
			this.ps = connection.prepareStatement(READ_ALL);
			this.rs = this.ps.executeQuery();
			while (this.rs.next()) {
				details.add(Mapper.orderDetails(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return details;
	}

	public ArrayList<OrderDetails> readByOrderID(Integer orderID){
		initStatements();
		ArrayList<OrderDetails> details = new ArrayList<>();
		try {
			this.ps = connection.prepareStatement(READ_BY_ORDERID);
			this.ps.setInt(1, orderID);
			this.rs = this.ps.executeQuery();
			while(this.rs.next()) {
				details.add(Mapper.orderDetails(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return details;
	}

}

package com.gmail.fomenkoc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.gmail.fomenkoc.dao.ProdDaoInterface;
import com.gmail.fomenkoc.domain.Prod;
import com.gmail.fomenkoc.utils.DBConnetcion;
import com.gmail.fomenkoc.utils.Mapper;

public class ProdDao implements ProdDaoInterface {

	private static final String READ_ALL = "SELECT * " 
										 + "FROM prod";
	private static final String CREATE = 
							"INSERT INTO prod(prod_name, description, price) "
						  + "VALUES(?, ?, ?)";
	private static final String READ = "SELECT * " 
						  			 + "FROM prod "
						  			 + "WHERE prod_id = ?";
	private static final String UPDATE = 
							  "UPDATE prod "
							+ "SET prod_name = ?, description = ?, price = ? "
							+ "WHERE prod_id = ?";
	private static final String DELETE = "DELETE " 
									   + "FROM prod "
									   + "WHERE prod_id = ?";
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;

	public ProdDao() {
		super();
		this.connection = DBConnetcion.getConnection();

	}

	private void initStatements() {
		this.ps = null;
		this.rs = null;
	}

	@Override
	public Prod create(Prod prod) {
		initStatements();

		try {
			this.ps = connection.prepareStatement(CREATE,
					Statement.RETURN_GENERATED_KEYS);
			this.ps.setString(1, prod.getProdName());
			this.ps.setString(2, prod.getDescription());
			this.ps.setDouble(3, prod.getPrice());
			this.ps.executeUpdate();
			this.rs = ps.getGeneratedKeys();
			this.rs.next();
			prod.setProdID(rs.getInt("prod_id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prod;
	}

	@Override
	public Prod read(Integer id) {
		initStatements();
		Prod prod = null;

		try {
			this.ps = connection.prepareStatement(READ);
			this.ps.setInt(1, id);
			this.rs = this.ps.executeQuery();
			this.rs.next();
			prod = Mapper.prod(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prod;
	}

	@Override
	public Prod update(Prod prod) {
		initStatements();

		try {
			this.ps = connection.prepareStatement(UPDATE);
			this.ps.setString(1, prod.getProdName());
			this.ps.setString(2, prod.getDescription());
			this.ps.setDouble(3, prod.getPrice());
			this.ps.setInt(4, prod.getProdID());
			this.ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prod;
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
	public ArrayList<Prod> readAll() {
		initStatements();
		ArrayList<Prod> prods = new ArrayList<>();
		try {
			this.ps = connection.prepareStatement(READ_ALL);
			this.rs = this.ps.executeQuery();
			while (this.rs.next()) {
				prods.add(Mapper.prod(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prods;
	}

}

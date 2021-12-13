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

public class ProdDao implements ProdDaoInterface {

	private static final String READ_ALL = "SELECT * "
										 + "FROM prod";
	private static final String CREATE = 
							"INSERT INTO prod(prod_name, description, price) "
						  + "VALUES(?, ?, ?)";
	private static final String READ = "SELECT * "
									 + "FROM prod "
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
			prod.setProdID(rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prod;
	}

	@Override
	public Prod read(Integer id) {
		initStatements();
		Prod prod = null;
		
		this.ps = connection.prepareStatement(READ);
		this.ps.setInt(1, id);
		this.rs = this.ps.executeQuery();
		this.rs.next();
		
		return prod;
	}

	@Override
	public Prod update(Prod t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Prod> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

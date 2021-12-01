package com.gmail.fomenkoc.store.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdPriceDao {

	private static final String READ_ALL = "SELECT * " 
										 + "FROM r_ProdPrice ";

	private static final String CREATE = 
								"INSERT INTO r_ProdPrice(ProdID, PLID, Price) "
							  + "VALUES(?, ?, ?) ";

	private static final String READ = "SELECT * " 
									 + "FROM r_ProdPrice "
									 + "WHERE ProdID = ? AND PLID = ? ";

	private static final String UPDATE = "UPDATE r_ProdPrice "
									   + "SET Price = ? " 
									   + "WHERE ProdID = ? AND PLID = ? ";

	private static final String DELETE = "DELETE " 
									   + "FROM r_ProdPrice "
									   + "WHERE ProdID = ? AND PLID = ? ";
	
	private Connection conn;
	private PreparedStatement ps;
	
	public ProdPriceDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public ArrayList<ProdPrice> readAll() throws SQLException {
		ps = conn.prepareStatement(READ_ALL);
		ResultSet rs = ps.executeQuery();
		ArrayList<ProdPrice> prodPrices = new ArrayList<ProdPrice>();
		while(rs.next()) {
			prodPrices.add(Mapper.prodPrice(rs));
		}
		return prodPrices;
	}
	
	public void create(ProdPrice prodPrice) throws SQLException {
		ps = conn.prepareStatement(CREATE);
		ps.setInt(1, prodPrice.getProdID());
		ps.setInt(2, prodPrice.getPlid());
		ps.setDouble(3, prodPrice.getPrice());
		ps.executeUpdate();
	}
	
	public ProdPrice read(ProdPrice prodPrice) throws SQLException {
		ps = conn.prepareStatement(READ);
		ps.setInt(1, prodPrice.getProdID());
		ps.setInt(2, prodPrice.getPlid());
		ResultSet rs = ps.executeQuery();
		rs.next();
		return Mapper.prodPrice(rs);
	}
	
	public void update(ProdPrice prodPrice) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		ps.setDouble(1, prodPrice.getPrice());
		ps.setInt(2, prodPrice.getProdID());
		ps.setInt(3, prodPrice.getPlid());
		ps.executeUpdate();
	}
	
	public void delete(ProdPrice prodPrice) throws SQLException {
		ps = conn.prepareStatement(DELETE);
		ps.setInt(1, prodPrice.getProdID());
		ps.setInt(2, prodPrice.getPlid());
		ps.executeUpdate();
	}
	
}

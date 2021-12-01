package com.gmail.fomenkoc.store.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdDao {
	
	private static final String READ_ALL = "SELECT * "
										 + "FROM r_Prods ";
	
	private static final String CREATE = "INSERT INTO r_Prods(ProdName, UM) "
									   + "VALUES(?, ?) ";
	
	private static final String READ = "SELECT * "
									 + "FROM r_Prods "
									 + "WHERE ProdID = ? ";
	
	private static final String UPDATE = "UPDATE r_Prods "
									   + "SET ProdName = ?, UM = ? "
									   + "WHERE ProdID = ? ";
	
	private static final String DELETE = "DELETE "
									   + "FROM r_Prods "
									   + "WHERE ProdID = ? ";
	
	private static final String NEW_ID = "SELECT MAX(ProdID) + 1 AS ProdID "
									   + "FROM r_Prods ";
	
	private Connection conn;
	private PreparedStatement ps;
	
	
	public ProdDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public int getNewProdID() throws SQLException {
		ps = conn.prepareStatement(NEW_ID);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt("ProdID");
	}
	
	public ArrayList<Prod> readAll() throws SQLException{
		ArrayList<Prod> prods = new ArrayList<>();
		ps = conn.prepareStatement(READ_ALL);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			prods.add(Mapper.prod(rs));
		}
		
		return prods;
	}

	public void create(Prod prod) throws SQLException {
		ps = conn.prepareStatement(CREATE);
		ps.setString(1, prod.getProdName());
		ps.setString(2, prod.getUnitMeasurement());
		ps.executeUpdate();
	}
	
	public Prod read(int id) throws SQLException {
		ps = conn.prepareStatement(READ);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		Prod prod = Mapper.prod(rs);
		return prod;
	}
	
	public Prod read(Prod searchProd) throws SQLException {
		ps = conn.prepareStatement(READ);
		ps.setInt(1, searchProd.getProdID());
		ResultSet rs = ps.executeQuery();
		rs.next();
		Prod prod = Mapper.prod(rs);
		return prod;
	}
	
	public void update(Prod prod) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		ps.setString(1, prod.getProdName());
		ps.setString(2, prod.getUnitMeasurement());
		ps.setInt(3, prod.getProdID());
		ps.executeUpdate();
	}

	public void delete(Prod prod) throws SQLException {
		ps = conn.prepareStatement(DELETE);
		ps.setInt(1, prod.getProdID());
		ps.executeUpdate();
	}
	
	public void delete(int prodID) throws SQLException {
		ps = conn.prepareStatement(DELETE);
		ps.setInt(1, prodID);
		ps.executeUpdate();
	}
	
	
	
	
	
}

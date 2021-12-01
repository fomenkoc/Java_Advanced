package com.gmail.fomenkoc.store.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BarCodeDao {
	private static final String READ_ALL = "SELECT * " 
										 + "FROM r_ProdBarCodes ";

	private static final String CREATE = 
								"INSERT INTO r_ProdBarCodes(ProdID, BarCode) "
							  + "VALUES(?, ?) ";

	private static final String READ = "SELECT * " 
									 + "FROM r_ProdBarCodes "
									 + "WHERE BarCode = ? ";

	private static final String READ_BY_PROD = "SELECT * " 
			 						 	     + "FROM r_ProdBarCodes "
			 						 	     + "WHERE ProdID = ? ";

	
	private static final String UPDATE = "UPDATE r_ProdBarCodes "
									   + "SET BarCode = ? " 
									   + "WHERE BarCode = ? ";

	private static final String DELETE = "DELETE " 
									   + "FROM r_ProdBarCodes "
									   + "WHERE BarCode = ? ";

	private Connection conn;
	private PreparedStatement ps;

	public BarCodeDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public ArrayList<BarCode> readAll() throws SQLException {
		ps = conn.prepareStatement(READ_ALL);
		ResultSet rs = ps.executeQuery();
		ArrayList<BarCode> barcodes = new ArrayList<>();
		while(rs.next()) {
			barcodes.add(Mapper.barCode(rs));
		}
		return barcodes;
	}
	
	public void create(BarCode barCode) throws SQLException {
		ps = conn.prepareStatement(CREATE);
		ps.setInt(1, barCode.getProdID());
		ps.setString(2, barCode.getBarCode());
		ps.executeUpdate();
	}
	
	public BarCode read(BarCode barCode) throws SQLException {
		ps = conn.prepareStatement(READ);
		ps.setString(1, barCode.getBarCode());
		ResultSet rs = ps.executeQuery();
		rs.next();
		return Mapper.barCode(rs);
	}
	
	public BarCode read(String barCode) throws SQLException {
		ps = conn.prepareStatement(READ);
		ps.setString(1, barCode);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return Mapper.barCode(rs);
	}
	
	public ArrayList<BarCode> readByProd(Prod prod) throws SQLException {
		ps = conn.prepareStatement(READ_BY_PROD);
		ps.setInt(1, prod.getProdID());
		ResultSet rs = ps.executeQuery();
		ArrayList<BarCode> barcodes = new ArrayList<>();
		while(rs.next()) {
			barcodes.add(Mapper.barCode(rs));
		}
		return barcodes;
	}

	public ArrayList<BarCode> readByProd(int prodID) throws SQLException {
		ps = conn.prepareStatement(READ_BY_PROD);
		ps.setInt(1, prodID);
		ResultSet rs = ps.executeQuery();
		ArrayList<BarCode> barcodes = new ArrayList<>();
		while(rs.next()) {
			barcodes.add(Mapper.barCode(rs));
		}
		return barcodes;
	}
	
	public void update(BarCode oldBarCode, BarCode newBarCode)
													throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		ps.setString(1, newBarCode.getBarCode());
		ps.setString(2, oldBarCode.getBarCode());
		ps.executeUpdate();
	}
	
	public void delete(BarCode barCode) throws SQLException {
		ps = conn.prepareStatement(DELETE);
		ps.setString(1, barCode.getBarCode());
		ps.executeUpdate();
	}
	
	
	
	
	
	
	
}

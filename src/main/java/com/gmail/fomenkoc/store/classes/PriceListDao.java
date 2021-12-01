package com.gmail.fomenkoc.store.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PriceListDao {
	
	private static final String READ_ALL = "SELECT * " + 
										   "FROM r_PriceLists ";

	private static final String CREATE = "INSERT INTO r_PriceLists(PLName) "
								  	   + "VALUES(?) ";

	private static final String READ = "SELECT * " 
									 + "FROM r_PriceLists "
									 + "WHERE PLID = ? ";

	private static final String UPDATE = "UPDATE r_PriceLists "
									   + "SET PLName = ? " 
									   + "WHERE PLID = ? ";

	private static final String DELETE = "DELETE " 
									   + "FROM r_PriceLists "
									   + "WHERE PLID = ? ";
	
	private Connection conn;
	private PreparedStatement ps;
	
	public PriceListDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public ArrayList<PriceList> readAll() throws SQLException {
		ps = conn.prepareStatement(READ_ALL);
		ResultSet rs = ps.executeQuery();
		ArrayList<PriceList> priceLists = new ArrayList<PriceList>();
		while(rs.next()) {
			priceLists.add(Mapper.priceList(rs));
		}
		return priceLists;
	}
	
	public void create(PriceList priceList) throws SQLException {
		ps = conn.prepareStatement(CREATE);
		ps.setString(1, priceList.getPlName());
		ps.executeUpdate();
	}
	
	public PriceList read(PriceList priceList) throws SQLException {
		ps = conn.prepareStatement(READ);
		ps.setInt(1, priceList.getPlid());
		ResultSet rs = ps.executeQuery();
		rs.next();
		return Mapper.priceList(rs);
	}
	
	public PriceList read(int plid) throws SQLException {
		ps = conn.prepareStatement(READ);
		ps.setInt(1, plid);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return Mapper.priceList(rs);
	}
	
	public void update(PriceList oldPriceList, PriceList newPriceList) 
														throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		ps.setString(1, newPriceList.getPlName());
		ps.setInt(2, oldPriceList.getPlid());
		ps.executeUpdate();
	}
	
	public void delete(PriceList priceList) throws SQLException {
		ps = conn.prepareStatement(DELETE);
		ps.setInt(1, priceList.getPlid());
		ps.executeUpdate();
	}
	
}

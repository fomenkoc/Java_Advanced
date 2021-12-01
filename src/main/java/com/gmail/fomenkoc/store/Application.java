package com.gmail.fomenkoc.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gmail.fomenkoc.store.classes.BarCode;
import com.gmail.fomenkoc.store.classes.BarCodeDao;
import com.gmail.fomenkoc.store.classes.DBConnetcion;
import com.gmail.fomenkoc.store.classes.PriceList;
import com.gmail.fomenkoc.store.classes.PriceListDao;
import com.gmail.fomenkoc.store.classes.Prod;
import com.gmail.fomenkoc.store.classes.ProdDao;
import com.gmail.fomenkoc.store.classes.ProdPrice;
import com.gmail.fomenkoc.store.classes.ProdPriceDao;
import com.gmail.fomenkoc.store.classes.User;
import com.gmail.fomenkoc.store.classes.UserDao;

public class Application {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = DBConnetcion.getConnection("user4lessons", "user4lessons");
//		PreparedStatement ps = connection.prepareStatement("SELECT * "
//														 + "FROM r_Prods");
//		ResultSet rs = ps.executeQuery();
//		
//		int prodID;
//		String prodName;
//		String um;
//		while(rs.next()) {
//			prodID = rs.getInt("ProdID");
//			prodName = rs.getString("ProdName");
//			um = rs.getString("UM");
//			
//			System.out.println(prodID + " " + prodName + " " + um);
//		}
		
//		ProdDao prodDao = new ProdDao(connection);
//		prodDao.create(new Prod("hz1", "hz"));
//		Prod prod = prodDao.read(21);
//		prod.setProdName("Crack");
//		prod.setUnitMeasurement("g");
//		prodDao.update(prod);
//		prodDao.delete(20);
		

//		System.out.println(prodDao.read(1));
//		System.out.println(prodDao.read(19));
//		System.out.println(prodDao.readAll());
//		System.out.println("\n\n");
		
//		BarCodeDao barCodeDao = new BarCodeDao(connection);
//		BarCode barCode = new BarCode(3, "4444444444444");
//		barCodeDao.create(barCode);
//		System.out.println(barCodeDao.readAll());
//		System.out.println(barCodeDao.read(barCode));
//		System.out.println(barCodeDao.read("4444444444444"));
//		System.out.println(barCodeDao.readByProd(3));
		
//		BarCode oldBarCode = new BarCode(3, "4444444444444");
//		BarCode newBarCode = new BarCode(3, "5555555555555");
//		barCodeDao.update(oldBarCode, newBarCode);
//		barCodeDao.delete(newBarCode);
//		System.out.println(barCodeDao.readAll());
		
//		PriceListDao priceListDao = new PriceListDao(connection);
//		PriceList priceList = new PriceList(3, "Test PL");
//		PriceList newPriceList = new PriceList(3, "New PL");
//		priceListDao.create(priceList);
//		priceListDao.update(priceList, newPriceList);
//		priceListDao.delete(newPriceList);
//		System.out.println(priceListDao.readAll());
//		System.out.println(priceListDao.read(1));
		
//		ProdPriceDao prodPriceDao = new ProdPriceDao(connection);
//		ProdPrice prodPrice = new ProdPrice(2, 1, 99.9);
//		prodPriceDao.create(prodPrice);
//		System.out.println(prodPriceDao.readAll());
//		System.out.println();
//		System.out.println(prodPriceDao.read(prodPrice));
//		prodPriceDao.update(prodPrice);
//		System.out.println(prodPriceDao.readAll());
//		prodPriceDao.delete(prodPrice);
//		System.out.println();
//		System.out.println(prodPriceDao.readAll());
		
//		User user = new User(2, "NewUser", true);
//		UserDao userDao = new UserDao(connection);
//		userDao.create(user);
//		userDao.update(user);
//		userDao.delete(user);
//		System.out.println(userDao.read(user));
//		System.out.println(userDao.readAll());
	}

}

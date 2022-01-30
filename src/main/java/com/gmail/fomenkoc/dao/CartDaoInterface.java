package com.gmail.fomenkoc.dao;

import java.util.List;

import com.gmail.fomenkoc.domain.Cart;
import com.gmail.fomenkoc.shared.CRUDInterface;

public interface CartDaoInterface extends CRUDInterface<Cart> {
	
	public List<Cart> readByUserID(Integer userID);

}

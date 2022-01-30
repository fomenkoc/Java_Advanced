package com.gmail.fomenkoc.dao;

import java.util.List;
import java.util.Map;

import com.gmail.fomenkoc.domain.Role;
import com.gmail.fomenkoc.shared.CRUDInterface;

public interface RoleDaoInterface extends CRUDInterface<Role> {
	
	public List<Role> readStaff();
	public Map<Integer, Role> readAllMap();

}

package com.gmail.fomenkoc.shared;

import java.util.List;

public interface CRUDInterface<T> {

	T create(T t);

	T read(Integer id);

	T update(T t);

	void delete(Integer id);
	
	List<T> readAll();
}

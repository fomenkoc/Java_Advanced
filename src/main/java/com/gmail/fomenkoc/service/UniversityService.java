package com.gmail.fomenkoc.service;

import com.gmail.fomenkoc.domain.University;

public interface UniversityService {

	University save(University university);

	University findByID(Long id);

	void delete(University university);

	Iterable<University> findAll();

}

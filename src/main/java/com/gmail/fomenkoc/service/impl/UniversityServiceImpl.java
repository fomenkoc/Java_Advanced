package com.gmail.fomenkoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.fomenkoc.dao.UniversityRepository;
import com.gmail.fomenkoc.domain.University;
import com.gmail.fomenkoc.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {

	@Autowired
	private UniversityRepository universityRepository;

	@Override
	public University save(University university) {

		return universityRepository.save(university);
	}

	@Override
	public University findByID(Long id) {

		return universityRepository.findById(id).get();
	}

	@Override
	public void delete(University university) {
		
		universityRepository.delete(university);
		
	}

	@Override
	public Iterable<University> findAll() {

		return universityRepository.findAll();
	}
	
}

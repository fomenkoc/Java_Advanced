package com.gmail.fomenkoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gmail.fomenkoc.dao.impl.StudentDaoImpl;
import com.gmail.fomenkoc.dao.interfaces.StudentDao;

@Configuration
public class HWConfiguration {

	@Bean(name = "studentDao")
	public StudentDao getStudentDao() {
		return new StudentDaoImpl();
	}
	
	
}

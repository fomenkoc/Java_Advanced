package com.gmail.fomenkoc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.gmail.fomenkoc.domain.Student;
import com.gmail.fomenkoc.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student storeStudent(String firstName, String lastName, Integer age,
			MultipartFile file) throws IOException {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Student student = null;

		if (!fileName.contains("..")) {
			student = new Student(firstName, lastName, age, file.getBytes(),
					fileName, file.getContentType());
		}

		return studentRepository.save(student);
	}
	
	public Student getStudent(Integer studentId) {
		return studentRepository.findById(studentId).orElse(null);
	}
	
	public List<Student> findAll(){
		return studentRepository.findAll();
	}

}

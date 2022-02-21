package com.gmail.fomenkoc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gmail.fomenkoc.domain.Student;
import com.gmail.fomenkoc.dto.StudentUploadResponse;
import com.gmail.fomenkoc.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/uploadStudent")
	public StudentUploadResponse uploadStudent(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("age") Integer age,
			@RequestParam("photo") MultipartFile photo) throws IOException {

		Student student = studentService.storeStudent(firstName, lastName, age,
				photo);

		String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/photos/").path(student.getId().toString())
				.toUriString();

		return new StudentUploadResponse(firstName, lastName, age, firstName,
				fileUri, photo.getContentType(), photo.getSize());
	}

	@GetMapping("/photos/{id}")
	public void getPhoto(@PathVariable Integer id, HttpServletResponse response)
			throws IOException {
		Student student = studentService.getStudent(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(student.getData());
		response.getOutputStream().close();
	}

	@GetMapping("/getStudents")
	public List<Student> findAllStudents(HttpServletResponse response) {
		List<Student> students = studentService.findAll();
		for (Student student : students) {
			student.setData(null);
		}
		return students;
	}
}

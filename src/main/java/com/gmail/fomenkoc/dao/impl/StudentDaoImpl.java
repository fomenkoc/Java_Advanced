package com.gmail.fomenkoc.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gmail.fomenkoc.dao.interfaces.StudentDao;
import com.gmail.fomenkoc.domain.Student;

public class StudentDaoImpl implements StudentDao{
	
	private static List<Student> students = new ArrayList<Student>();

	@Override
	public Student create(Student student) {
		if (student.getId() == 0) {
		Integer id = 0;
		for (Student tmpStudent : students) {
			if (tmpStudent.getId() > id) {
				id = tmpStudent.getId();
			}
		}
		student.setId(++id);
		}
		students.add(student);
		
		return student;
	}

	@Override
	public Student read(Integer id) {
		Student retStudent = null;
		for (Student student : students) {
			if (student.getId() == id) {
				retStudent = student;
			}
		}
		return retStudent;
	}

	@Override
	public Student update(Student student) {
		delete(student.getId());
		create(student);
		return student;
	}

	@Override
	public void delete(Integer id) {
		for (Iterator<Student> iterator = students.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			if (student.getId() == id) {
				iterator.remove();
			}
		}
//		students.remove((int) id);
		
	}

	@Override
	public List<Student> readAll() {

		return students;
	}

}

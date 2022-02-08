package com.gmail.fomenkoc;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.gmail.fomenkoc.dao.interfaces.StudentDao;
import com.gmail.fomenkoc.domain.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication
				.run(Application.class, args);
		
		StudentDao dao = (StudentDao) context.getBean("studentDao");
		
		Student student1 = new Student("Bender Rodriguez", 26);
		Student student2 = new Student("Philip J. Fry", 32);
		Student student3 = new Student("Homer J. Simpson", 42);
		
		System.out.println("Create:");
		dao.create(student1);
		dao.create(student2);
		dao.create(student3);
		System.out.println();
		
		System.out.println("Read all:");
		List<Student> students = dao.readAll(); 
		System.out.println(students);
		System.out.println();

		System.out.println("Read & Update:");
		Student updStudent = dao.read(1);
		updStudent.setName("Bender Bending Rodriguez");
		dao.update(updStudent);
		students = dao.readAll(); 
		System.out.println(students);
		System.out.println();
		
		System.out.println("Delete:");
		dao.delete(3);
		students = dao.readAll(); 
		System.out.println(students);
		System.out.println();
		
		
	}

}

package com.gmail.fomenkoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.gmail.fomenkoc.domain.University;
import com.gmail.fomenkoc.service.UniversityService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication
				.run(Application.class, args);

		UniversityService univercityService = context
				.getBean(UniversityService.class);

		// create
		System.out.println("_______________________________________________");
		System.out.println("Create");
		University un1 = new University("Technical school", 1, 5, 6,
				"127.0.0.0");
		University un2 = new University("College", 2, 5, 6, "127.0.0.0");
		University un3 = new University("Conservatory", 3, 5, 6, "127.0.0.0");
		University un4 = new University("University", 4, 5, 6, "localhost");
		University un5 = new University("Test university", 3, 5, 6,
				"127.0.0.0");

		univercityService.save(un1);
		univercityService.save(un2);
		univercityService.save(un3);
		univercityService.save(un4);
		univercityService.save(un5);

		// read
		System.out.println("_______________________________________________");
		System.out.println("Read");
		University readUniversity = univercityService.findByID(1L);
		System.out.println(readUniversity);
		
		// read all
		System.out.println("_______________________________________________");
		System.out.println("Read all");
		univercityService.findAll().forEach(u -> System.out.println(u));
		System.out.println("_______________________________________________");

		// update
		System.out.println("_______________________________________________");
		System.out.println("Update");
		University updUniversity = univercityService.findByID(4L);
		System.out.println("Before:");
		System.out.println(updUniversity);
		updUniversity.setAddress("127.0.0.0");
		univercityService.save(updUniversity);
		System.out.println("After:");
		System.out.println(updUniversity);

		// delete
		System.out.println("_______________________________________________");
		System.out.println("Delete");
		University delUniversity = univercityService.findByID(5L);
		System.out.println(delUniversity);
		univercityService.delete(delUniversity);

		// read all
		System.out.println("_______________________________________________");
		System.out.println("Read all");
		univercityService.findAll().forEach(u -> System.out.println(u));
		System.out.println("_______________________________________________");
		
		

	}

}

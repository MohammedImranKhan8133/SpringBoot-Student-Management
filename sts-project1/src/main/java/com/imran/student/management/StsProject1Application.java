package com.imran.student.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.imran.student.management.entity.Student;
import com.imran.student.management.repository.StudentRepository;

@SpringBootApplication
public class StsProject1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StsProject1Application.class, args);
	}
	
	@Autowired
	StudentRepository repository;

	@Override
	public void run(String... args) throws Exception {


		Student student1 = new Student("Ramesh", "Fadatare", "ramesh@gmail.com");
		repository.save(student1);

		Student student2 = new Student("Sanjay", "Jadhav", "sanjay@gmail.com");
		repository.save(student2);

		Student student3 = new Student("tony", "stark", "tony@gmail.com");
		repository.save(student3);


	}

}

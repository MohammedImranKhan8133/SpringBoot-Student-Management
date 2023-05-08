package com.imran.student.management.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imran.student.management.entity.Student;
import com.imran.student.management.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{

	@Autowired
	StudentRepository repository;

	@Override
	public Student saveStudent(Student student) {
		return repository.save(student);
	}


	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		Student studentDB=repository.findById(id).get();

		if(Objects.nonNull(student.getFirstName()) &&
				!"".equalsIgnoreCase(student.getFirstName())) {
			studentDB.setFirstName(student.getFirstName());
		}

		if(Objects.nonNull(student.getLastName()) &&
				!"".equalsIgnoreCase(student.getLastName())) {
			studentDB.setLastName(student.getLastName());
		}
		
		if(Objects.nonNull(student.getEmail()) &&
				!"".equalsIgnoreCase(student.getEmail())) {
			studentDB.setLastName(student.getEmail());
		}

		return repository.save(studentDB);
	}

	@Override
	public void deleteStudent(Long id) {
		repository.deleteById(id);
	}
}

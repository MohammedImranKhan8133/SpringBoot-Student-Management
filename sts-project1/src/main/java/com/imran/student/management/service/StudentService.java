package com.imran.student.management.service;

import java.util.List;

import com.imran.student.management.entity.Student;

public interface StudentService {

	Student saveStudent(Student student);

	List<Student> getAllStudent();

	Student updateStudent(Long id, Student student);

	void deleteStudent(Long id);
 
}

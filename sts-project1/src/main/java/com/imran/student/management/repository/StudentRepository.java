package com.imran.student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imran.student.management.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

}

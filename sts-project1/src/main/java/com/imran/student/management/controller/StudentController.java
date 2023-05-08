package com.imran.student.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.imran.student.management.entity.Student;
import com.imran.student.management.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService service;

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students",service.getAllStudent());
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable("id") Long id,Model model) {
		Student student = new Student();
		student.setId(id);
		model.addAttribute("student",student);
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable("id") Long id,
			@ModelAttribute("student") Student student) {
		service.updateStudent(id, student);
		return "redirect:/students";		
	}

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		service.deleteStudent(id);
		return "redirect:/students";
	}

}

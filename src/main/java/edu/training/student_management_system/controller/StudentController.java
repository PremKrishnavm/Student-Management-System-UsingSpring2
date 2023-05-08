package edu.training.student_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.training.student_management_system.entity.Student;
import edu.training.student_management_system.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student student, @RequestParam int adminId) {
		return studentService.saveStudent(student,adminId);
	}
}

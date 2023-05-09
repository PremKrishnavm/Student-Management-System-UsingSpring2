package edu.training.student_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.training.student_management_system.entity.Student;
import edu.training.student_management_system.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@PostMapping
	public Student saveStudent(@RequestBody Student student, @RequestParam int adminId) {
		return studentService.saveStudent(student,adminId);
	}
	
	@GetMapping
	public Student findStudentById(@RequestParam int studentId) {
		return studentService.findStudentById(studentId);
	}
	
	@PutMapping
	public Student updateStudentById(@RequestParam int studentId,@RequestBody Student student) {
		return studentService.updateStudentById(studentId, student);
	}
	
	@DeleteMapping
	public Student deleteBuId(@RequestParam int studentId, @RequestParam int adminId) {
		return studentService.deleteStudentById(studentId,adminId);
	}
	
	@GetMapping("/admin")
	public List<Student> getStudents(@RequestParam int adminId){
		return studentService.getStudents(adminId);
	}
}

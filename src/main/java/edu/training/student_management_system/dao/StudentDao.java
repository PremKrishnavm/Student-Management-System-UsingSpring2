package edu.training.student_management_system.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.training.student_management_system.entity.Student;
import edu.training.student_management_system.repository.StudentRepo;

@Repository
public class StudentDao {
	
	@Autowired
	private StudentRepo studentRepo;
	
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}
}

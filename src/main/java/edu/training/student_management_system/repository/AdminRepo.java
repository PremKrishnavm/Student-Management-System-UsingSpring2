package edu.training.student_management_system.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.training.student_management_system.entity.Admin;
import edu.training.student_management_system.entity.Student;


public interface AdminRepo extends JpaRepository<Admin, Integer>{
	
	@Query(value = "select a.students from Admin a where a.adminId=?1")
	public Optional<List<Student>> getStudents(int adminId);
}

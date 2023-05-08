package edu.training.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.training.student_management_system.entity.Admin;


public interface AdminRepo extends JpaRepository<Admin, Integer>{
	
}

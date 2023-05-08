package edu.training.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.training.student_management_system.entity.Student;


public interface StudentRepo extends JpaRepository<Student, Integer>{

}

package edu.training.student_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.training.student_management_system.dao.AdminDao;
import edu.training.student_management_system.dao.StudentDao;
import edu.training.student_management_system.entity.Admin;
import edu.training.student_management_system.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private AdminDao adminDao;
	
	public Student saveStudent(Student student, int adminId) {
		
		//finding the Admin present in database
		Admin admin = adminDao.findAdminById(adminId);
		//Fetching the existing student list with admin
		List<Student> students = admin.getStudents();
		//Assigning the new student to the existing student list
		students.add(student);
		//setting the student list with new student to the admin
		admin.setStudents(students);
		// saving student to the database
		Student student2 = studentDao.saveStudent(student);
		//updating the student to the admin in the database
		adminDao.saveAdmin(admin);
		
		return student2;
	}
	
	public Student findStudentById(int studentId) {
		return studentDao.findStudentById(studentId);
	}
	
	public Student updateStudentById(int studentId,Student student) {
		return studentDao.updateStudentById(studentId, student);
	}
	
	public Student deleteStudentById(int studentId, int adminId) {
		Student student = studentDao.findStudentById(studentId);
		if(student!=null) {
			 Admin admin = adminDao.findAdminById(adminId);
			 if(admin!=null) {
				 List<Student> students = admin.getStudents();
				 students.remove(student);
				 admin.setStudents(students);
				 adminDao.updateAdminById(adminId, admin);
				 studentDao.deleteStudentBuId(studentId);
				 return student;
			 }else {
				 return null;
			 }
		}else {
			return null;
		}
	}
	
	public List<Student> getStudents(int adminId){
		return studentDao.getStudents(adminId);
	}
}

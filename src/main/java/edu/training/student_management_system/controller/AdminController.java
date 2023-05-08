package edu.training.student_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.training.student_management_system.dao.AdminDao;
import edu.training.student_management_system.entity.Admin;



@RestController
public class AdminController {
	
	@Autowired
	private AdminDao adminDao;
	
	@PostMapping("/admin")
	public Admin saveAdmin(@RequestBody Admin admin) {
		return adminDao.saveAdmin(admin);
	}
}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.result.Result;
import com.example.demo.service.EmployeeserviceImpl;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeserviceImpl employeeserviceImpl;

	@GetMapping("/get-all-employees")
	public Result getAllEmployees() {
		return employeeserviceImpl.findAllEmployees();
	}

	@GetMapping("/get-employee-by-email")
	public Result getEmployeeByEmail(@RequestParam("email") String email) {
		return employeeserviceImpl.findEmployeeByEmail(email);
	}
	
}

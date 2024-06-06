package com.Employee2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Employee2.response.EmployeeResponse;
import com.Employee2.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees/{id}")
	ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id){
		
		 EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
		 // use ctrl+1 to get class name and local variable name
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
		
	}

}

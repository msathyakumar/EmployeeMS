package com.employeems.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeems.project.model.EmployeeDTo;
import com.employeems.project.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/save")
	public EmployeeDTo saveEmployee(@RequestBody EmployeeDTo employeeDto) {
		return employeeService.saveEmployee(employeeDto);
	}

	@GetMapping("/all")
	public List<EmployeeDTo> getAllEmployees() {
		return employeeService.getAllEmployee();
	}

}

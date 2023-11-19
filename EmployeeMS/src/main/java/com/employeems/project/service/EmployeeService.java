package com.employeems.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeems.project.model.EmployeeDTo;

@Service
public interface EmployeeService {

	EmployeeDTo saveEmployee(EmployeeDTo employeeDto);

	List<EmployeeDTo> getAllEmployee();

	EmployeeDTo getEmployeeById(String id);

}

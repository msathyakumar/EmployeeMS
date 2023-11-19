package com.employeems.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employeems.project.model.EmployeeDTo;
import com.employeems.project.service.EmployeeService;

@SpringBootApplication
public class EmployeeMsApplication implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EmployeeDTo emp = new EmployeeDTo("Emp001", "Sathya", "sathya@gmail.com", "pwd", "male", 45000);
		EmployeeDTo emp1 = new EmployeeDTo("Emp002", "kumar", "sathya@gmail.com", "pwd", "male", 45000);
		employeeService.saveEmployee(emp1);
		employeeService.saveEmployee(emp);
	}

}

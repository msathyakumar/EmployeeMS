package com.employeems.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.employeems.project.model.EmployeeDTo;
import com.employeems.project.model.Location;
import com.employeems.project.service.EmployeeService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EmployeeMsApplication implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EmployeeDTo emp = new EmployeeDTo("Emp001", "Sathya", "sathya@gmail.com", "pwd", "male", 45000,new Location("Loc001", null, null, null, null));
		EmployeeDTo emp1 = new EmployeeDTo("Emp002", "kumar", "sathya@gmail.com", "pwd", "male", 45000, new Location("Loc002", null, null, null, null));
		employeeService.saveEmployee(emp1);
		employeeService.saveEmployee(emp);
	}

}

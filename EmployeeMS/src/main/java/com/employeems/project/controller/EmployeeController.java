package com.employeems.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.employeems.project.feign.LocationFeign;
import com.employeems.project.model.EmployeeDTo;
import com.employeems.project.model.Location;
import com.employeems.project.service.EmployeeService;

@RestController
public class EmployeeController {

//	@Autowired
//	DiscoveryClient discoveryClient;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	LocationFeign locationFeign;

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/save")
	public EmployeeDTo saveEmployee(@RequestBody EmployeeDTo employeeDto) {
		return employeeService.saveEmployee(employeeDto);
	}

	@GetMapping("/all")
	public List<EmployeeDTo> getAllEmployees() {

		List<EmployeeDTo> finalList = new ArrayList<>();
		var list = employeeService.getAllEmployee();
		for (EmployeeDTo emp : list) {
//			var location = restTemplate.getForObject("http://localhost:8090/get/" + emp.getLocation().getId(),
//					Location.class);
			var location = locationFeign.getById(emp.getLocation().getId());
			emp.setLocation(location);
			finalList.add(emp);
		}

		return finalList;
	}

	@GetMapping("/get/{id}")
	public EmployeeDTo getByEmpID(@PathVariable("id") String id) {
		var emp = employeeService.getEmployeeById(id);
//		var clients = discoveryClient.getInstances("LOCATIONMS");
//		var firstService = clients.get(0).getUri();
//		var location = restTemplate.getForObject(firstService+"/get/" + emp.getLocation().getId(),
//				Location.class);

//		var location = restTemplate.getForObject("http://LOCATIONMS/get/" + emp.getLocation().getId(), Location.class);
		var location = locationFeign.getById(emp.getLocation().getId());

		emp.setLocation(location);
		return emp;
	}

}

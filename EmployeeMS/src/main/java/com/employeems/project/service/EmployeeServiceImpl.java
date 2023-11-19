package com.employeems.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeems.project.entity.Employee;
import com.employeems.project.model.EmployeeDTo;
import com.employeems.project.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeDTo saveEmployee(EmployeeDTo employeeDto) {
		return Employee.employeeDto(employeeRepository.save(employeeDto.toEmployee()));
	}

	@Override
	public List<EmployeeDTo> getAllEmployee() {
		var list = employeeRepository.findAll();
		return list.stream().map(a -> a.employeeDto(a)).toList();
	}

	@Override
	public EmployeeDTo getEmployeeById(String id) {
		var emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			return Employee.employeeDto(emp.get());
		}
		return new EmployeeDTo();
	}

}

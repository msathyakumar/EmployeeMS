package com.employeems.project.entity;

import com.employeems.project.model.EmployeeDTo;
import com.employeems.project.model.Location;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	private String empId;
	private String empName;
	private String emailId;
	private String password;
	private String gender;
	private double salary;
	private String locationId;
//	private Location location;
	
	public static EmployeeDTo employeeDto(Employee emp) {
		
		return new EmployeeDTo(emp.getEmpId(), emp.getEmpName(), emp.getEmailId(), emp.getPassword(), emp.getGender(), emp.getSalary());
		
	}

}

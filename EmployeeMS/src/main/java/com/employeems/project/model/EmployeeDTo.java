package com.employeems.project.model;

import com.employeems.project.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTo {
	private String empId;
	private String empName;
	private String emailId;
	private String password;
	private String gender;
	private double salary;
//	private Location location;
	
	public Employee toEmployee() {
		return new Employee(this.empId, this.empName, this.emailId, this.password, this.gender, this.salary,"");
	}
}

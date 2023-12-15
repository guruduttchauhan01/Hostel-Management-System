package com.guru.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departments {
	@Id
	@Column(name = "dept_no")
	private String departmentNumber;
	
	@Column(name = "dept_name")
	private String departmentName;
	
	@OneToMany(mappedBy = "department")
	private List<Employee> employee;
	
	
	
	public Departments(String departmentNumber, String departmentName) {
		super();
		this.departmentNumber = departmentNumber;
		this.departmentName = departmentName;
	}
	
	public Departments() {
		super();
	}

	public String getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(String departmentNumber) {
		this.departmentNumber = departmentNumber;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	public List<Employee> getEmployees() {
		return employee;
	}
	public void setEmployees(List<Employee> employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Department Number: " + departmentNumber 
				+ "\nDepartmentName: " + departmentName;
	}

	
	
}

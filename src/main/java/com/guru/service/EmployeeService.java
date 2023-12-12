package com.guru.service;

import java.util.List;

import com.guru.entities.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	Employee getEmployee(int employeeId);
	Employee createEmployee(Employee employee);
}

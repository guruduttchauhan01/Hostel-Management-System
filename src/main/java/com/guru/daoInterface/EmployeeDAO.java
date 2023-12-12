package com.guru.daoInterface;

import java.util.List;

import com.guru.entities.Employee;

public interface EmployeeDAO {
	List<Employee> getAllEmployees();
	Employee getEmployee(int employeeId);
	Employee createEmployee(Employee employee);
}

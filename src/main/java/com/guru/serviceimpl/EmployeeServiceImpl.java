package com.guru.serviceimpl;

import java.util.List;

import com.guru.daoImpl.EmployeeDaoImpl;
import com.guru.daoInterface.EmployeeDAO;
import com.guru.entities.Employee;
import com.guru.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO employeeDAO = new EmployeeDaoImpl();
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployees();
	}

	@Override
	public Employee getEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee(employeeId);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.createEmployee(employee);
	}

}

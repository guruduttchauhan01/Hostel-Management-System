package com.guru.daoInterface;

import java.util.List;

import com.guru.entities.Departments;

public interface DepartmentsDAO {
	Departments getDepartment(String department);
	List<Departments> getAllDepartments();
	Departments createDepartment(Departments department);
}

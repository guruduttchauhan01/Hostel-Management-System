package com.guru.service;

import java.util.List;

import com.guru.entities.Departments;

public interface DepartmentsService {
	Departments getDepartment(String department);
	List<Departments> getAllDepartments();
	Departments createDepartment(Departments department);
}

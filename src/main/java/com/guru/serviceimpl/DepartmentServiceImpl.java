package com.guru.serviceimpl;

import java.util.List;

import com.guru.daoImpl.DepartmentsDaoImpl;
import com.guru.daoInterface.DepartmentsDAO;
import com.guru.entities.Departments;
import com.guru.service.DepartmentsService;

public class DepartmentServiceImpl implements DepartmentsService {
	
	DepartmentsDAO departmentDao = new DepartmentsDaoImpl();
	@Override
	public Departments getDepartment(String department) {
		// TODO Auto-generated method stub
		return departmentDao.getDepartment(department);
	}

	@Override
	public List<Departments> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentDao.getAllDepartments();
	}

	@Override
	public Departments createDepartment(Departments department) {
		// TODO Auto-generated method stub
		return departmentDao.createDepartment(department);
	}

}

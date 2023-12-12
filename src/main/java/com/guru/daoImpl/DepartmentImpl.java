package com.guru.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.guru.daoInterface.DepartmentsDAO;
import com.guru.entities.Departments;
import com.guru.util.HibernateUtil;

public class DepartmentImpl implements DepartmentsDAO {

	@Override
	public Departments getDepartment(String department) {
		try(Session session = HibernateUtil.getSession()) {
			Departments dpt = session.get(Departments.class, department);
			return dpt;
		}catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Departments> getDepartmentEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departments getAllDepartments() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

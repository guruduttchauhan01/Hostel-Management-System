package com.guru.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.guru.daoInterface.DepartmentsDAO;
import com.guru.entities.Departments;
import com.guru.util.HibernateUtil;
import org.hibernate.query.Query;

public class DepartmentsDaoImpl implements DepartmentsDAO {

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



	@SuppressWarnings("unchecked")
	@Override
	public List<Departments> getAllDepartments() {
		try(Session session=HibernateUtil.getSession()) {

			Query<Departments> query=session.createQuery("FROM Departments");
			List<Departments> departmentList = query.list();
			return departmentList;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Departments createDepartment(Departments department) {
		// TODO Auto-generated method stub
		try(Session session = HibernateUtil.getSession()) {
			
			session.beginTransaction();
			session.save(department);
			session.getTransaction().commit();
			return department;
		}catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
}

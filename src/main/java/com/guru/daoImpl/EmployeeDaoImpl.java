package com.guru.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.guru.daoInterface.EmployeeDAO;
import com.guru.entities.Employee;
import com.guru.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDAO {

	@Override
	public List<Employee> getAllEmployees() {
		try(Session session=HibernateUtil.getSession()) {

			@SuppressWarnings("unchecked")
			Query<Employee> query=session.createQuery("FROM Employee");
			List<Employee> employeeList = query.list();
			return employeeList;
			
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
	public Employee getEmployee(int employeeId) {
		try(Session session=HibernateUtil.getSession()) {

			@SuppressWarnings("unchecked")
			Query<Employee> query=session.createQuery("FROM Employee where employeeNumber = :id");
			query.setParameter("id", employeeId);
			Employee employee = query.getSingleResult();
			return employee;
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
	public Employee createEmployee(Employee employee) {
		try(Session session = HibernateUtil.getSession()) {
			
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
			return employee;
		}catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
}

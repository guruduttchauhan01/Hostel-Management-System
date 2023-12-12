package com.guru.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.guru.entities.Departments;
import com.guru.entities.Employee;
import com.guru.entities.Hostel;
import com.guru.entities.Room;
import com.guru.entities.Student;


public class HibernateUtil {
	
	private final static SessionFactory sessionFactory=buildSessionFactory();
private static SessionFactory buildSessionFactory()
{

	try {
		return new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Departments.class)
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Hostel.class)
				.addAnnotatedClass(Room.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
	}catch (Throwable e) {
		throw new ExceptionInInitializerError(e);
	}
}

public static SessionFactory getSessionFactory() {
	return sessionFactory;
}

public static Session getSession()
{
  return getSessionFactory().openSession();
}
	
}

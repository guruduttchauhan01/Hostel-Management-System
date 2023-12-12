package com.guru.defualtEntries;

import org.hibernate.Session;

import com.guru.entities.Departments;
import com.guru.util.HibernateUtil;

public class DefaultEntries {
//	public static SessionFactory factory = new Configuration().configure().buildSessionFactory();
//	public static void searchId(int studentId) {
//		Session session = factory.openSession();
//		
//		Student student = (Student) session.get(Student.class, studentId);
//		
//		if(student != null) {
//			System.out.println("\n\n"+"=".repeat(50));
//			System.out.println("\t\t\tStudent Details\n");
//			System.out.println(student);
//			System.out.println("=".repeat(50));
//		} else {
//			System.out.println("_".repeat(50));
//			System.out.println("!!!Incorrect student ID!!!");
//			System.out.println("_".repeat(50));
//		}
//		session.close();
//		factory.close();
//	}
	
	public void setDepartments() {
		try(Session session = HibernateUtil.getSession()) {
			Departments administration = new Departments();
			administration.setDepartmentName("Manager");
			administration.setDepartmentNumber("GF/01");
			Departments accomdationDept = new Departments();
			accomdationDept.setDepartmentName("Room Maintainace");
			Departments foodDepartment = new Departments();
			foodDepartment.setDepartmentName("Kitchen Staff");
			foodDepartment.setDepartmentNumber("GF/02");
			Departments securityDept = new Departments();
			securityDept.setDepartmentName("Security");
			securityDept.setDepartmentNumber("GF/03");
			
			session.beginTransaction();
			session.save(administration);
			session.save(accomdationDept);
			session.save(foodDepartment);
			session.save(securityDept);
			session.getTransaction().commit();
		}
	}
}

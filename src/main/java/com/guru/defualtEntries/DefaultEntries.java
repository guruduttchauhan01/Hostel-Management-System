package com.guru.defualtEntries;

import java.util.ArrayList;
import java.util.List;

import com.guru.daoImpl.DepartmentsDaoImpl;
import com.guru.entities.Departments;

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
		Departments administration = new Departments();
		administration.setDepartmentName("Manager");
		administration.setDepartmentNumber("GF/01");
		
		Departments accomdationDept = new Departments();
		accomdationDept.setDepartmentName("Room Maintainace");
		accomdationDept.setDepartmentNumber("GF/02");
		
		Departments foodDepartment = new Departments();
		foodDepartment.setDepartmentName("Kitchen Staff");
		foodDepartment.setDepartmentNumber("GF/03");
		
		Departments securityDept = new Departments();
		securityDept.setDepartmentName("Security");
		securityDept.setDepartmentNumber("GF/04");
		
		List<Departments> dptList = new ArrayList<Departments>();
		dptList.add(administration);
		dptList.add(accomdationDept);
		dptList.add(foodDepartment);
		dptList.add(securityDept);
		
		DepartmentsDaoImpl dim = new DepartmentsDaoImpl();
		for(Departments d : dptList) {
			dim.createDepartment(d);
		}
	}
}

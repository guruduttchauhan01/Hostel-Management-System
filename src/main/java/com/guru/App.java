package com.guru;

import java.util.*;


public class App {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		
//		SessionFactory factory = new Configuration().configure().buildSessionFactory();
//		
//		Departments dp = new Departments();
//		
//		dp.setDepartmentNumber("SDE001");
//		dp.setDepartmentName("Software Developer Engineer");
//		
//		Employee e = new Employee();
//		e.setFirstName("Guru");
//		e.setLastName("Dutt");
//		e.setDob(Date.valueOf("2000-02-01"));
//		e.setContact("8278889005");
//		e.setDepartment(dp);
//		e.setAddress("Solan");
//		e.setSalary(20000);
//		List<Employee> em = new ArrayList<Employee>();
//		em.add(e);
//		dp.setEmployee(em);
//		
//		Session session = factory.openSession();
//		
//		Transaction tx = session.beginTransaction();
//		
//		session.save(dp);
//		session.save(e);
//		
//		tx.commit();
//		
//		session.close();
//		factory.close();

		
		mainOps();
		
		
	}
	
	public static void mainOps() {
		while(true) {
			String mainMenu = """
					--------------------------------------------------------------------------------------
					NOTE: If you haven't setup you Hostel setup before selecting anything to setup press 1.
					--------------------------------------------------------------------------------------
					Press 1: Start setup the Hostel Management System
					Press 2: Student Operations
					Press 3: Employee Operations
					Press 4: Get Student Details
					
					***********Press 5/q/quit: to exit***********
					
					""";
			System.out.println(mainMenu);
			System.out.print("Enter your input: ");
			String i = input.nextLine();
			if(i.equals("5") || i.equals("q") || i.equals("quit")) {
				break;
			} else if (i.equals("1")) {
				AllOperations.hostelSetUp();
			} else if (i.equals("2")) {
				AllOperations.studentOperations();
			} else if (i.equals("3")) {
				AllOperations.employeeOperations();
			}
		}
	}
}

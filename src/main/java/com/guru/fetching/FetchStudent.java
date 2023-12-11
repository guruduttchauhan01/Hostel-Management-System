package com.guru.fetching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.guru.entities.Student;

public class FetchStudent {
	public static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	public static void searchId(int studentId) {
		Session session = factory.openSession();
		
		Student student = (Student) session.get(Student.class, studentId);
		
		if(student != null) {
			System.out.println("\n\n"+"=".repeat(50));
			System.out.println("\t\t\tStudent Details\n");
			System.out.println(student);
			System.out.println("=".repeat(50));
		} else {
			System.out.println("_".repeat(50));
			System.out.println("!!!Incorrect student ID!!!");
			System.out.println("_".repeat(50));
		}
		session.close();
		factory.close();
	}
}

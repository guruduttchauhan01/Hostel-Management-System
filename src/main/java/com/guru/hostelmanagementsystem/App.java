package com.guru.hostelmanagementsystem;

import java.sql.Date;
import java.text.ParseException;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//import com.guru.entities.Block;
import com.guru.entities.Departments;
import com.guru.entities.Employee;
//import com.guru.entities.Room;
//import com.guru.entities.Student;
//
//import com.guru.fetching.FetchStudent;
//import com.guru.insertion.StudentInsertion;

//import java.io.FileInputStream;

/**
 * Hello world!
 *
 */
public class App {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws ParseException {
//    	String menu = "-".repeat(50) + "\n"
//    			+ "1. Check Student details\n"
//    			+ "2. Insert Student details\n"
//    			+ "3. Exit\n"
//    			+ "NOTE: PICK ONE OPTION FROM ABOVE OPTIONS\n"
//    			+ "-".repeat(50);
//    	while(true) {
//    		System.out.println(menu);
//    		System.out.print("Enter option: ");
//    		int option = input.nextInt();
//    		
//    		if(option == 1) {
//    			System.out.print("Enter student id: ");
//    			int id = input.nextInt();
//    			
//    			FetchStudent.searchId(id);
//    			
//    		} else if (option == 2) {
//    			StudentInsertion.insertStudent();
//    			System.out.println("\n\n\t\t\tSuccessfully Inserted Data\n\n\n");
//    			continue;
//    		} else if (option == 3) {
//    			input.close();
//    			return;
//    		} else {
//    			System.out.println("Invalid Input!!!");
//    		}
//    	}

//		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// Block
//		Block block = new Block();
//		block.setBlockName("BalaJi");
//		block.setCapacity(100);
//		block.setTotalRooms(50);
//
//		// Rooms
//		Room room1 = new Room();
//		room1.setBlock(block);
//		room1.setRoomCapacity(5);
//		room1.setRoomNo(1);
//
//		Room room2 = new Room();
//		room2.setBlock(block);
//		room2.setRoomNo(2);
//		room2.setRoomCapacity(4);
//
//		List<Room> rooms = new ArrayList<Room>();
//		rooms.add(room1);
//		rooms.add(room2);
//		block.setRooms(rooms);

    	//Students
//		Student s = new Student();
//		s.setFirst_name("Guru");
//		s.setLast_name("Dutt");
//		s.setGender('M');
//		s.setAddress("Solan");
//		s.setEmail("gurudutt");
//		s.setContact("8278889905");
//		s.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("2000-02-01"));
//		s.setBlockName(block);
//		s.setRoomNo(room1);
//
//		Student s1 = new Student();
//		s1.setFirst_name("Atika");
//		s1.setLast_name("Chauhan");
//		s1.setGender('F');
//		s1.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("2000-02-01"));
//		s1.setAddress("Solan");
//		s1.setEmail("gurudutt");
//		s1.setContact("8278889905");
//		s1.setBlockName(block);
//		s1.setRoomNo(room1);
//		
//
//		List<Student> students = new ArrayList<Student>();
//		students.add(s);
//		students.add(s1);
//
//		block.setStudents(students);
//		room1.setStudents(students);
//
//		Session session = factory.openSession();
//
//		Transaction tx = session.beginTransaction();
//
//		session.save(block);
//		session.save(room1);
//		session.save(room2);
//		session.save(s);
//		session.save(s1);
//
//		tx.commit();
//		session.close();

		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Departments dp = new Departments();
		
		dp.setDepartmentNumber("SDE001");
		dp.setDepartmentName("Software Developer Engineer");
		
		Employee e = new Employee();
		e.setFirstName("Guru");
		e.setLastName("Dutt");
		e.setDob(Date.valueOf("2000-02-01"));
		e.setContact("8278889005");
		e.setDepartment(dp);
		e.setAddress("Solan");
		e.setSalary(20000);
		List<Employee> em = new ArrayList<Employee>();
		em.add(e);
		dp.setEmployee(em);
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(dp);
		session.save(e);
		
		tx.commit();
		
		session.close();
		factory.close();
		
	}
}
package com.guru.insertion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.guru.entities.Student;

public class StudentInsertion {
	
	public static Scanner input = new Scanner(System.in);
	
	public static void insertStudent() {
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
    	Student student = new Student();
    	
    	System.out.print("Enter first name: ");
    	String first_name = input.nextLine();
    	student.setFirst_name(first_name);
    	
    	System.out.print("Enter last name: ");
    	String last_name = input.nextLine();
    	student.setLast_name(last_name);
    	
    	System.out.println("Male/Female/Other");
    	System.out.print("Enter your gender: ");
    	String gender = input.next().toUpperCase();
    	student.setGender(gender.charAt(0));
    	
    	try {
    		int year;
    		int currentYear = LocalDate.now().getYear();
        	while(true) {
        		System.out.print("Enter your DOB(Date Of Birth) year: ");
        		year = input.nextInt();
        		if(year >= 1900 && year < currentYear) {
        			break;
        		}else {
        			System.out.println("Not Valid!!!");
        			continue;
        		}
        		
        	}
        	
        	int month;
        	while(true) {
        		System.out.print("Enter your DOB(Date Of Birth in number) month: ");
        		month = input.nextInt();
        		if(month >= 1 && month <= 12) {
        			break;
        		}else {
        			System.out.println("Not Valid!!!");
        			continue;
        		}
        	}
        	int day;
        	while(true) {
        		System.out.print("Enter your DOB(Date Of Birth in number) day: ");
        		day = input.nextInt();
        		input.nextLine();
        		String c = "";
        		switch(month) {
        			case 1, 3, 5, 7, 8, 10, 12 : c += "a"; break;
        			case 4, 6, 9, 11 : c += "b"; break;
        			case 2 : c += "c"; break;
        		}
        		if(c.equals("a") && day >= 01 && day <= 31) {
        			break;
        		}else if (c.equals("b") && day >= 01 && day <= 30){
        			break;
        		}else if(c.equals("c") && day >= 1 && day <= 29) {
        			break;
        		} else {
        			System.out.println("Not Valid!!!" + c + day + month);
        			continue;
        		}
        	}
    		
    		student.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(year + "-"+ month + "-" + day));
    		input.next();
    	}catch(ParseException e) {
    		System.out.println(e.getMessage());
    	}
    	
//    	Calendar calendarDate = Calendar.getInstance(
//    			  TimeZone.getTimeZone("UTC"));
//    	
//    	
//    	
//    	
//    	
//    	student.setDob(calendarDate);
    	
    	
    	System.out.print("Enter address: ");
    	String address = input.nextLine();
    	student.setAddress(address);
    	
    	System.out.print("Enter contact number: ");
    	String contactNumber = input.nextLine();
    	student.setContact(contactNumber);
    	
    	System.out.print("Enter email: ");
    	String email = input.nextLine();
    	student.setEmail(email);
    	
//    	FileInputStream fis = new FileInputStream("src/main/java/Guru_Dutt_Chauhan1.jpg");
//    	byte[] data = new byte[fis.available()];
//    	fis.read();
//    	student.setImage(data);
    	
    	Session session = factory.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	
    	session.save(student);
    	tx.commit();
    	session.close();
//    	fis.close();
	}
}

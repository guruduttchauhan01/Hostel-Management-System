package com.guru;

import java.util.*;


public class App {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
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
				input.close();
				break;
			} else if (i.equals("1")) {
				AllOperations.hostelSetUp();
			} else if (i.equals("2")) {
				AllOperations.studentOperations();
			} else if (i.equals("3")) {
				AllOperations.employeeOperations();
			} else if (i.equals("4")) {
				AllOperations.getAllStudents();
			} else {
				System.out.println("invalid input");
			}
		}
	}
}

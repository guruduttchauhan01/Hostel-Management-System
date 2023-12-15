package com.guru;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.guru.entities.Departments;
import com.guru.entities.Employee;
import com.guru.entities.Hostel;
import com.guru.entities.Room;
import com.guru.entities.Student;
import com.guru.service.DepartmentsService;
import com.guru.service.EmployeeService;
import com.guru.service.HostelService;
import com.guru.service.RoomService;
import com.guru.service.StudentService;

import com.guru.serviceimpl.DepartmentServiceImpl;
import com.guru.serviceimpl.EmployeeServiceImpl;
import com.guru.serviceimpl.HostelServiceImpl;
import com.guru.serviceimpl.RoomServiceImpl;
import com.guru.serviceimpl.StudentServiceImpl;

public class AllOperations {
	
	static HostelService hs = new HostelServiceImpl(); 
	static RoomService rs = new RoomServiceImpl();
	static DepartmentsService ds = new DepartmentServiceImpl();
	static EmployeeService es = new EmployeeServiceImpl();
	static StudentService ss = new StudentServiceImpl();
	
	static Scanner input = new Scanner(System.in);
	public static Hostel setUpHostel() {
		System.out.print("Enter hostel name: ");
		String hostelName = input.nextLine();
		System.out.print("Enter hostel capacity for student: ");
		int capacity = input.nextInt();
		System.out.print("Enter total rooms in hostel: ");
		int totalRooms = input.nextInt();
		return new Hostel(hostelName, capacity, totalRooms);
	}
	
	public static void hostelSetUp() {
		if(hs.getHostel() != null) {
			System.out.println("\n\n" + "*".repeat(25) + "Hostel found!!" + "*".repeat(25));
			System.out.println(hs.getHostel() + "\n");
			System.out.println("*".repeat(64));
			return;
		}
		
		String hostelStartUp = """
				
				==========================Enter Below Details==========================
				Then we set up the room and then departments after that you are ready
				
				""";
		System.out.println(hostelStartUp);
		Hostel hostel = setUpHostel();
		Hostel savedEntity = hs.createHostel(hostel);
		System.out.println("\n\n"+"*".repeat(10)+"Hostel has been created successfully!!!!" + "*".repeat(10) + "\n" + savedEntity);
		System.out.println("*".repeat(100));
		
		//Setting up room
		String roomStartUp = """
				
				==========================Enter Below Details==========================
									Let's start building our rooms
				
				""";
		System.out.println(roomStartUp);
		List<Room> rooms = setUpRoom(hostel);
		rs.setRoom(rooms);
		System.out.println("\n\n" + "*".repeat(10) + "Rooms has been setup successfully!!!" + "*".repeat(10) + "\n");
		
		
		//Setting up Departments
		String departmentSetUp = """
				
				==========================Enter Below Details==========================
									Let's start building our departments
				
				""";
		System.out.println(departmentSetUp);
		setUpDepartment();
		System.out.println("\n\n" + "*".repeat(10) + "Departments has been setup successfully!!!" + "*".repeat(10) + "\n");
	}
	
	public static List<Room> setUpRoom(Hostel hostel) {
		System.out.print("How many students per room: ");
		int spr = input.nextInt();
		int totalCapacity = hostel.getCapacity();
		List<Room> rooms = new ArrayList<Room>();
		while(spr > 0 && totalCapacity > 0) {
			rooms.add(new Room(spr, hostel));
			totalCapacity -= spr;
		}
		return rooms;
	}
	
	
	public static void setUpDepartment() {
		String option = """
				
				***********************Choose one option***********************
				
				1. Set Default Departments
				2. Manually Set Departments
				
				""";
		System.out.println(option);
		System.out.print("Enter your option: ");
		int opt = input.nextInt();
		if (opt == 1) {
			//Adding Default departments
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
			
			ds.createDepartment(administration);
			ds.createDepartment(accomdationDept);
			ds.createDepartment(foodDepartment);
			ds.createDepartment(securityDept);
		} else if(opt == 2) {
			//Manually department
			while(true) {
				String departmentOptions = """
						1. Create department
						2. Exit
						""";
				System.out.println(departmentOptions);
				
				//Asking user for input to choose exit or create department
				System.out.print("Enter option: ");
				int inp = input.nextInt();
				if (inp == 1) {
					//Creating department using inputs from user
					System.out.print("Enter department number: ");
					String dptNumber = input.nextLine();
					System.out.println("Enter department name: ");
					String dptName = input.nextLine();
					
					ds.createDepartment(new Departments(dptNumber, dptName));
					
				} else if(inp == 2) {
					break;
				} else {
					System.out.println("!!Invalid Option!!");
				}
				
			}
		} else {
			System.out.println("!!Invalid Input!!");
		}
	}
	
	//Employee Operations
	public static void employeeOperations() {
		String menu = "-".repeat(50) + "\n"
    			+ "1. Check Employee details\n"
    			+ "2. Insert Employee details\n"
    			+ "3. Exit\n"
    			+ "NOTE: PICK ONE OPTION FROM ABOVE OPTIONS\n"
    			+ "-".repeat(50);
    	while(true) {
    		System.out.println(menu);
    		System.out.print("Enter option: ");
    		int option = input.nextInt();
    		
    		if(option == 1) {
    			System.out.print("Enter employee id: ");
    			int id = input.nextInt();
    			Employee e = es.getEmployee(id);
    			System.out.println("\n\n" + "*".repeat(50));
    			System.out.println(e);
    			System.out.println("\n\n" + "*".repeat(50));
    			
    		} else if (option == 2) {
    			input.nextLine();
    			Employee employee = new Employee();
    	    	
    	    	System.out.print("Enter first name: ");
    	    	String first_name = input.nextLine();
    	    	employee.setFirstName(first_name);
    	    	
    	    	System.out.print("Enter last name: ");
    	    	String last_name = input.nextLine();
    	    	employee.setLastName(last_name);
    	    	
    	    	System.out.println("Male/Female/Other");
    	    	System.out.print("Enter your gender: ");
    	    	String gender = input.next().toUpperCase();
    	    	employee.setGender(gender.charAt(0));
    	    	
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
    	        			case 1: case 3: case 5: case 7: case 8: case 10: case 12: c += "a"; break;
    	        			case 4: case 6: case 9: case 11: c += "b"; break;
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
    	    		String dd = year + "-" + month + "-" + day;
    	    		employee.setDob(Date.valueOf(dd));
    	    		
    	    		
    	    	System.out.print("Enter address: ");
    	    	String address = input.nextLine();
    	    	employee.setAddress(address);
    	    	
    	    	System.out.print("Enter contact number: ");
    	    	String contactNumber = input.nextLine();
    	    	employee.setContact(contactNumber);
    	    	
    	    	System.out.print("Enter salary amount: ");
    	    	double salary = input.nextInt();
    	    	employee.setSalary(salary);
    	    	
    	    	while(true) {
    	    		System.out.println(ds.getAllDepartments());
        	    	System.out.println("*".repeat(50));
        	    	System.out.print("Select one department number and Enter here: ");
        	    	String dep = input.nextLine();
        	    	Departments department = ds.getDepartment(dep);
        	    	if(department != null) {
        	    		employee.setDepartment(department);
        	    		break;
        	    	} else {
        	    		System.out.println("Invalid Department number entered");
        	    	}
        	    	
    	    	}
    	    	
    	    	
    	    	employee.setHostel(hs.getHostel());
    	    	
    	    	Employee employeeInserted = es.createEmployee(employee);
    			System.out.println("\n\n\t\t\tSuccessfully Inserted Data\n\n\n");
    			System.out.println(employeeInserted);
    			continue;
    		} else if (option == 3) {
    			return;
    		} else {
    			System.out.println("Invalid Input!!!");
    		}
    	}
	}
	
	
	public static void studentOperations() {
		String menu = "-".repeat(50) + "\n"
    			+ "1. Check Student details\n"
    			+ "2. Insert Student details\n"
    			+ "3. Exit\n"
    			+ "NOTE: PICK ONE OPTION FROM ABOVE OPTIONS\n"
    			+ "-".repeat(50);
    	while(true) {
    		System.out.println(menu);
    		System.out.print("Enter option: ");
    		int option = input.nextInt();
    		
    		if(option == 1) {
    			System.out.print("Enter student id: ");
    			int id = input.nextInt();
    			Student s = ss.getStudent(id);
    			System.out.println("\n\n" + "*".repeat(50));
    			System.out.println(s);
    			System.out.println("\n\n" + "*".repeat(50));
    			
    		} else if (option == 2) {
    			input.nextLine();
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
    	        			case 1: case 3: case 5: case 7: case 8: case 10: case 12: c += "a"; break;
    	        			case 4: case 6: case 9: case 11: c += "b"; break;
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
    	    		String dd = year + "-" + month + "-" + day;
    	    		student.setDob(Date.valueOf(dd));
    	    		
    	    		
    	    	System.out.print("Enter address: ");
    	    	String address = input.nextLine();
    	    	student.setAddress(address);
    	    	
    	    	System.out.print("Enter contact number: ");
    	    	String contactNumber = input.nextLine();
    	    	student.setContact(contactNumber);
    	    	
    	    	System.out.print("Enter email: ");
    	    	String email = input.nextLine();
    	    	student.setEmail(email);
    	    	
    	    	student.setHostelName(hs.getHostel());
    	    	System.out.println("Room ranges from: " + 1 + " to " + hs.getHostel().getCapacity());
    	    	while(true) {
    	    		System.out.print("Enter a room number: ");
        	    	int roomNumber = input.nextInt();
        	    	if(roomNumber >= 1 && roomNumber <= hs.getHostel().getCapacity()) {
        	    		student.setRoomNo(rs.getRoom(roomNumber));
        	    		break;
        	    	} else {
        	    		System.out.println("Invalid Input/exceeds the limit of rooms");
        	    	}
        	    	
    	    	}
    	    	
    	    	
    	    	Student studentInserted = ss.createStudent(student);
    			System.out.println("\n\n\t\t\tSuccessfully Inserted Data\n\n\n");
    			System.out.println(studentInserted);
    			continue;
    		} else if (option == 3) {
    			return;
    		} else {
    			System.out.println("Invalid Input!!!");
    		}
    	}
	}
	
	public static void getAllStudents() {
		List<Student> students = ss.getAllStudents();
		for(Student student : students) {
			System.out.println(student);
		}
	}
}

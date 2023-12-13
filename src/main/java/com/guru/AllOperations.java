package com.guru;

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
		String startUp = """
				
				==========================Enter Below Details==========================
				Then we set up the room and then departments after that you are ready
				
				""";
		System.out.println(startUp);
		Hostel hostel = setUpHostel();
		Hostel savedEntity = hs.createHostel(hostel);
		System.out.println("\n\n"+"*".repeat(10)+"Hostel has been created successfully!!!!" + "*".repeat(10) + "\n" + savedEntity);
		System.out.println("*".repeat(25));
		
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
	
	
	public static Departments setUpDepartment() {
		return null;
	}
	public static Employee createEmployee() {
		return null;
	}
	public static Student createStudent() {
		return null;
	}
}

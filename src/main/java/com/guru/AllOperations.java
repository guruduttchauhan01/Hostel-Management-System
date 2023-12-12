package com.guru;

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
	
	
	public static Hostel setUpHostel() {
		
		return null;
	}
	public static Room setUpRoom() {
		return null;
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

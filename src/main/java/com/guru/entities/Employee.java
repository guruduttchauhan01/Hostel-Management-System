package com.guru.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeesNumber;
	
	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;
	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;
	@Column(name = "Gender", length = 10, nullable = false)
	private char gender;
	@Column(name = "DOB", nullable = false)
	private Date dob;
	@Column(nullable = false)
	private String address;
	@Column(length = 50, nullable = false)
	private String contact;
	@Column(nullable = false)
	private double salary;
	
	@ManyToOne
	@JoinColumn(name = "dept_no")
	private Departments department;
	
	@ManyToOne
	@JoinColumn(name = "hostel_no")
	private Hostel hostel;
	
	

	public Employee(int employeesNumber, String firstName, String lastName, char gender, Date dob, String address,
			String contact, double salary, Departments department, Hostel hostel) {
		super();
		this.employeesNumber = employeesNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.contact = contact;
		this.salary = salary;
		this.department = department;
		this.hostel = hostel;
	}
	
	
	public Employee() {
		super();
	}


	public int getEmployeesNumber() {
		return employeesNumber;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}
	
	

	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Departments getDepartment() {
		return department;
	}

	public void setDepartment(Departments department) {
		this.department = department;
	}
	public Hostel getHostel() {
		return hostel;
	}
	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}
	@Override
	public String toString() {
		return "Employee Id: " + employeesNumber
			+ "\nFirst Name: " + firstName
			+ "\nLast Name: " + lastName
			+ "\nGender: " + gender 
			+ "\nDOB: " + dob
			+ "\nContact: " + contact 
			+ "\nAddress: "+ address
			+ "\nSalary: " + salary 
			+ "\nDepartment: " + department.getDepartmentName()
			+ "\nHostel: " + hostel.getHostelName();
	}
	
	
	
}

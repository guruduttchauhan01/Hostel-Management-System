package com.guru.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.persistence.Lob;

@Entity
public class Student {
	@Id
	@Column(name = "s_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int studentId;
	@Column(length = 50, nullable = false)
	private String first_name;
	@Column(length = 50, nullable = false)
	private String last_name;
	@Column(name = "Gender", length = 10, nullable = false)
	private char gender;
	@Temporal(TemporalType.DATE)
	@Column(name = "DOB", nullable = false)
	private Date dob;
	@Column(length = 50, nullable = false)
	private String email;
	@Column(length = 15, nullable = false)
	private String contact;
	@Column(nullable = false)
	private String address;
	@ManyToOne
	@JoinColumn(name = "hostel_name")
	private Hostel hostel;
	@ManyToOne
	@JoinColumn(name = "room")
	private Room room;
	
	
	
	
	public Student(String first_name, String last_name, char gender, Date dob, String email,
			String contact, String address, Hostel hostel, Room roomNo) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.hostel = hostel;
		this.room = roomNo;
	}

	public Student() {
		super();
	}

	public int getStudentId() {
		return studentId;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Hostel getHostel() {
		return hostel;
	}

	public void setHostelName(Hostel hostel) {
		this.hostel = hostel;
	}

	public Room getRoomNo() {
		return room;
	}

	public void setRoomNo(Room roomNo) {
		this.room = roomNo;
	}

	@Override
	public String toString() {
		return "Student Id: " + studentId
				+ "\nFirst Name: " + first_name 
				+ "\nLast Name: " + last_name
				+ "\nGender: " + gender 
				+ "\nDOB: " + dob
				+ "\nEmail: " + email
				+ "\nContact: " + contact 
				+ "\nAddress: "+ address
				+ "\nHostel: " + hostel.getHostelName()
				+ "\nRoom: " + room.getRoomNo();
	}
	
	
	
}

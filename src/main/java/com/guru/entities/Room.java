package com.guru.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_no")
	private int roomNo;
	@Column(name = "room_capacity")
	private int roomCapacity;
	
	@ManyToOne
	@JoinColumn(name = "hostel_name")
	private Hostel hostel;
	
	@OneToMany(mappedBy = "room")
	private List<Student> students;
	
	public Room(int roomCapacity, Hostel hostel) {
		super();
		this.roomCapacity = roomCapacity;
		this.hostel = hostel;
	}
	
	public Room() {
		super();
	}

	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public int getRoomCapacity() {
		return roomCapacity;
	}
	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}
	public Hostel getBlock() {
		return hostel;
	}
	public void setBlock(Hostel hostel) {
		this.hostel = hostel;
	}
	@Override
	public String toString() {
		return "Room No: " + roomNo + "\nRoom Capacity: " + roomCapacity + "\nHostel: " + hostel.getHostelName();
	}
	
	
	
}

package com.guru.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Room {
	@Id
	@Column(name = "room_no")
	private int roomNo;
	@Column(name = "room_capacity")
	private int roomCapacity;
	
	@ManyToOne
	@JoinColumn(name = "block_name")
	private Hostel hostel;
	
	@OneToMany(mappedBy = "room")
	private List<Student> students;
	
	
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
	
	
}

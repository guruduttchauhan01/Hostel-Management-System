package com.guru.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hostel {
	@Id
	@Column(name = "block_name")
	private String blockName;
	private int capacity;
	@Column(name = "total_rooms")
	private int totalRooms;
	@OneToMany(mappedBy = "block")
	private List<Room> rooms;
	
	@OneToMany(mappedBy = "block")
	private List<Student> students;
	
	@OneToMany(mappedBy = "block")
	private List<Employee> employee;
	
	
	
	
	public List<Student> getStudents() {
		return students;
	}
	
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public String getBlockName() {
		return blockName;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getTotalRooms() {
		return totalRooms;
	}
	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}
	
	

}

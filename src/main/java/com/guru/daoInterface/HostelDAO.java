package com.guru.daoInterface;

import com.guru.entities.Hostel;

public interface HostelDAO {
	Hostel getHostelName(String hostelName);
	Hostel getTotalRooms();
	Hostel getTotalStudents();
	Hostel getTotalEmployees();
}

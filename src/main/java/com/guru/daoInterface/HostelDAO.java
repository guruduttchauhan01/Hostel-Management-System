package com.guru.daoInterface;

import com.guru.entities.Hostel;

public interface HostelDAO {
	Hostel creatHostel(Hostel hostel);
	Hostel getHostelName(String hostelName);
}

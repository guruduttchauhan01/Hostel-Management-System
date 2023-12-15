package com.guru.daoInterface;

import com.guru.entities.Hostel;

public interface HostelDAO {
	Hostel createHostel(Hostel hostel);
	Hostel getHostelName(String hostelName);
	Hostel getHostel();
}

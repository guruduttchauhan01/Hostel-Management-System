package com.guru.service;

import com.guru.entities.Hostel;

public interface HostelService {
	Hostel createHostel(Hostel hostel);
	Hostel getHostelName(String hostelName);
	Hostel getHostel();
}

package com.guru.serviceimpl;

import com.guru.daoImpl.HostelDaoImpl;
import com.guru.daoInterface.HostelDAO;
import com.guru.entities.Hostel;
import com.guru.service.HostelService;

public class HostelServiceImpl implements HostelService {

	HostelDAO hostelDao = new HostelDaoImpl();
	@Override
	public Hostel createHostel(Hostel hostel) {
		// TODO Auto-generated method stub
		return hostelDao.createHostel(hostel);
	}

	@Override
	public Hostel getHostelName(String hostelName) {
		// TODO Auto-generated method stub
		return hostelDao.getHostelName(hostelName);
	}

	
}

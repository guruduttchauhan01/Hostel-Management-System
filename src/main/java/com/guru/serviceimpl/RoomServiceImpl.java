package com.guru.serviceimpl;

import java.util.List;

import com.guru.daoImpl.RoomDaoImpl;
import com.guru.daoInterface.RoomDAO;
import com.guru.entities.Room;
import com.guru.service.RoomService;

public class RoomServiceImpl implements RoomService {

	RoomDAO rd = new RoomDaoImpl();
	
	@Override
	public List<Room> setRoom(List<Room> rooms) {
		// TODO Auto-generated method stub
		return rd.setRoom(rooms);
	}
	
	@Override
	public Room getRoom(int roomNumber) {
		// TODO Auto-generated method stub
		return rd.getRoom(roomNumber);
	}

	@Override
	public int getRoomCapacity(int roomNumber) {
		// TODO Auto-generated method stub
		return rd.getRoomCapacity(roomNumber);
	}

	

}

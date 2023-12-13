package com.guru.daoInterface;

import java.util.List;

import com.guru.entities.Room;

public interface RoomDAO {
	List<Room> setRoom(List<Room> rooms);
	Room getRoom(int roomNumber);
	int getRoomCapacity(int roomNumber);
}

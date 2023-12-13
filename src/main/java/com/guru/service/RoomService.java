package com.guru.service;

import java.util.List;

import com.guru.entities.Room;

public interface RoomService {
	List<Room> setRoom(List<Room> rooms);
	Room getRoom(int roomNumber);
	int getRoomCapacity(int roomNumber);
}

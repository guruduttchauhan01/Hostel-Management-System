package com.guru.service;

import com.guru.entities.Room;

public interface RoomService {
	Room getRoom(int number);
	Room getRoomCapacity();
	Room getTotalStudent();
	Room getStudent();
}

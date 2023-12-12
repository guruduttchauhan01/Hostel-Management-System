package com.guru.daoInterface;

import com.guru.entities.Room;

public interface RoomDAO {
	Room getRoom(int number);
	Room getRoomCapacity();
	Room getTotalStudent();
	Room getStudent();
}

package com.guru.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.guru.daoInterface.RoomDAO;
import com.guru.entities.Room;
import com.guru.util.HibernateUtil;

public class RoomDaoImpl implements RoomDAO {

	@Override
	public List<Room> setRoom(List<Room> rooms) {
		try(Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			for(Room room : rooms) {
				session.save(room);
			}
			session.getTransaction().commit();
			return rooms;
		}catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Room getRoom(int roomNumber) {
		try(Session session = HibernateUtil.getSession()) {
			Room room = session.get(Room.class, roomNumber);
			return room;
		}catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public int getRoomCapacity(int roomNumber) {
		
		try(Session session = HibernateUtil.getSession()) {
			Room room = session.get(Room.class, roomNumber);
			int capacity = room.getRoomCapacity();
			return capacity;
		}catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	

}

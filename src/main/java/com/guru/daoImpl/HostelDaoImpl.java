package com.guru.daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.guru.daoInterface.HostelDAO;
import com.guru.entities.Hostel;
import com.guru.util.HibernateUtil;

public class HostelDaoImpl implements HostelDAO {

	@Override
	public Hostel createHostel(Hostel hostel) {
		try(Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(hostel);
			session.getTransaction().commit();
			return hostel;
		}catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Hostel getHostelName(String hostelName) {
		try(Session session = HibernateUtil.getSession()) {
			Hostel hostel = session.get(Hostel.class, hostelName);
			return hostel;
		}catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Hostel getHostel() {
		// TODO Auto-generated method stub
		try(Session session = HibernateUtil.getSession()) {
			String q = "from Hostel";
			@SuppressWarnings("unchecked")
			Query<Hostel> query = session.createQuery(q);
			Hostel hostel = query.uniqueResult();
			return hostel;
		}catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}


}

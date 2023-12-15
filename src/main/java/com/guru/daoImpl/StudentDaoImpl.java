package com.guru.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.guru.daoInterface.StudentDAO;
import com.guru.entities.Student;
import com.guru.util.HibernateUtil;

public class StudentDaoImpl implements StudentDAO {

	@Override
	public Student createStudent(Student student) {
		try(Session session = HibernateUtil.getSession()) {
			
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			return student;
		}catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		try(Session session=HibernateUtil.getSession()) {

			@SuppressWarnings("unchecked")
			Query<Student> query=session.createQuery("FROM Student");
			List<Student> studentList = query.list();
			return studentList;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Student getStudent(int studentId) {
		try(Session session=HibernateUtil.getSession()) {

			@SuppressWarnings("unchecked")
			Query<Student> query=session.createQuery("FROM Student where studentId = :id");
			query.setParameter("id", studentId);
			Student student = query.getSingleResult();
			return student;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}

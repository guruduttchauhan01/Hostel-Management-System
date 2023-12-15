package com.guru.serviceimpl;

import java.util.List;

import com.guru.daoImpl.StudentDaoImpl;
import com.guru.daoInterface.StudentDAO;
import com.guru.entities.Student;
import com.guru.service.StudentService;

public class StudentServiceImpl implements StudentService {
	StudentDAO studentDAO = new StudentDaoImpl();
	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDAO.createStudent(student);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentDAO.getAllStudents();
	}

	@Override
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		return studentDAO.getStudent(studentId);
	}
	
}

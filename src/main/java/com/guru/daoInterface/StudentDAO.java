package com.guru.daoInterface;

import java.util.List;

import com.guru.entities.Student;

public interface StudentDAO {
	Student createStudent(Student student);
	List<Student> getAllStudents();
	Student getStudent(int studentId);
}

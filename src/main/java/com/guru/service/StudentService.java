package com.guru.service;

import java.util.List;

import com.guru.entities.Student;

public interface StudentService {
	Student createStudent(Student student);
	List<Student> getAllStudents();
	Student getStudent(int studentId);
}

package com.example.ExampleAPI.student.service.impl;

import java.util.List;

import com.example.ExampleAPI.student.model.Student;

public interface IStudent {
	List<Student> getAllStudents();
    Student findById(long id);
    Student findByEmailContaining(String email);
    Student save(Student std);
    void deleteById(long id);
}

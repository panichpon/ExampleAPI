package com.example.ExampleAPI.student.payload;

import com.example.ExampleAPI.student.model.Course;
import com.example.ExampleAPI.student.model.Student;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EnrolmentPayload {
	private Student student;
	private Course course;
}

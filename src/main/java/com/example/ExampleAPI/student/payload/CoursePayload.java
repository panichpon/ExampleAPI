package com.example.ExampleAPI.student.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CoursePayload {
	private String name;
	private String department;
}

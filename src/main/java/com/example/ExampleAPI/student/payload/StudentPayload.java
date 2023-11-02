package com.example.ExampleAPI.student.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class StudentPayload {

	private String firstName;
	private String lastName;
	private String email;
	private int age;
	
}

package com.example.ExampleAPI.student.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExampleAPI.student.json.CourseListJson;
import com.example.ExampleAPI.student.service.CourseService;

@Service
public class CourseBusiness {
	
	@Autowired
	CourseService courseService;
	
	public CourseListJson getCourseId(long id) {
		return CourseListJson.packJson(courseService.findById(id));
	}
	
}

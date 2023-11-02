package com.example.ExampleAPI.student.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExampleAPI.student.json.StudentIDCardListJson;
import com.example.ExampleAPI.student.service.StudentIDCardService;


@Service
public class StudentIDCardBusiness {
	
	@Autowired
	StudentIDCardService studentIdCardService;
	
	public List<StudentIDCardListJson> getListStudentIdCard() {
		return StudentIDCardListJson.packJsons(studentIdCardService.findAllStudentIdCards());
	}
	
	public StudentIDCardListJson getStudentIdCardByStudentId(long id) {
		return StudentIDCardListJson.packJson(studentIdCardService.findByStudentId(id));
	}
}

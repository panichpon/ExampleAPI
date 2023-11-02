package com.example.ExampleAPI.student.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExampleAPI.student.json.EnrolmentListJson;
import com.example.ExampleAPI.student.model.Enrolment;
import com.example.ExampleAPI.student.service.EnrolmentService;

@Service
public class EnrolmentBusiness {
	
	@Autowired
	EnrolmentService enrolmentService;
	
	public EnrolmentListJson getEnrolmentByStudentId(long id) {
		return EnrolmentListJson.packJson(enrolmentService.findByStudentId(id));
	}
	
	public List<EnrolmentListJson> getAllEnrolmentByStudentId(long id) {
		List<Enrolment> enrolments = enrolmentService.findByStudentIdList(id);
		return EnrolmentListJson.packJsons(enrolments);
	}
	
	public List<EnrolmentListJson> getAllEnrolmentByCoursetId(long id) {
		List<Enrolment> enrolments = enrolmentService.findByCoursetIdList(id);
		return EnrolmentListJson.packJsons(enrolments);
	}
}

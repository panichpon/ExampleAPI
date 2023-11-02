package com.example.ExampleAPI.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExampleAPI.student.business.BookBusiness;
import com.example.ExampleAPI.student.business.CourseBusiness;
import com.example.ExampleAPI.student.business.EnrolmentBusiness;
import com.example.ExampleAPI.student.business.StudentBusiness;
import com.example.ExampleAPI.student.business.StudentIDCardBusiness;
import com.example.ExampleAPI.student.exception.StudentException;
import com.example.ExampleAPI.student.json.BookListJson;
import com.example.ExampleAPI.student.json.CourseListJson;
import com.example.ExampleAPI.student.json.EnrolmentListJson;
import com.example.ExampleAPI.student.json.StudentIDCardListJson;
import com.example.ExampleAPI.student.json.StudentListJson;
import com.example.ExampleAPI.student.model.Student;
import com.example.ExampleAPI.student.payload.StudentPayload;
import com.example.ExampleAPI.student.service.StudentService;

import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	StudentService studentservice;

	@Autowired
	StudentBusiness stdBusiness;
	
	@Autowired
	StudentIDCardBusiness stdIdCardBusiness; 
	
	@Autowired
	EnrolmentBusiness enrolmentBusiness;
	
	@Autowired
	BookBusiness bookBusiness;
	
	@Autowired
	CourseBusiness courseBusiness;

	public StudentController(StudentService studentservice) {
		this.studentservice = studentservice;
	}

	@PostMapping(value = "/students")
	public ResponseEntity<Void> saveStudent(@RequestBody StudentPayload payload) throws StudentException {
		stdBusiness.saveStudent(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(value = "/students")
	public ResponseEntity<List<StudentListJson>> getAllStudents() throws StudentException {
		return ResponseEntity.ok(stdBusiness.getListStudent());
	}

	@GetMapping(value = "/students/{id}")
	public ResponseEntity<StudentListJson> getStudentById(@PathVariable("id") @Min(1) long id) throws StudentException {
		return ResponseEntity.ok(stdBusiness.getStudentId(id));
	}
	
	@GetMapping(value = "/students/{id}/card")
	public ResponseEntity<StudentIDCardListJson> getStudentIdCardByStudentId(@PathVariable("id") @Min(1) long id) throws StudentException {
		return ResponseEntity.ok(stdIdCardBusiness.getStudentIdCardByStudentId(id));
	}
	
	@GetMapping(value = "/students/{id}/enrolment")
	public ResponseEntity<EnrolmentListJson> getEnrolmentByStudentId(@PathVariable("id") @Min(1) long id) throws StudentException {
		return ResponseEntity.ok(enrolmentBusiness.getEnrolmentByStudentId(id));
	}
	
	@GetMapping(value = "/students/{id}/enrolments")
	public ResponseEntity<List<EnrolmentListJson>> getAllEnrolmentByStudentId(@PathVariable("id") @Min(1) long id) throws StudentException {
		return ResponseEntity.ok(enrolmentBusiness.getAllEnrolmentByStudentId(id));
	}
	
	@GetMapping(value = "/students/{id}/book")
	public ResponseEntity<BookListJson> getBookByStudentId(@PathVariable("id") @Min(1) long id) throws StudentException {
		return ResponseEntity.ok(bookBusiness.getBookByStudentId(id));
	}
	
	@GetMapping(value = "/course/{id}")
	public ResponseEntity<CourseListJson> getCourseById(@PathVariable("id") @Min(1) long id) throws StudentException {
		return ResponseEntity.ok(courseBusiness.getCourseId(id));
	}

	@PutMapping("/students/{id}")
	public ResponseEntity<StudentListJson> updateStudent(@PathVariable("id") long id,
			@RequestBody StudentPayload payload) {
		Optional<Student> stdData = studentservice.findOptionalById(id);
		if(stdData.isPresent()) {
			stdBusiness.updateStudent(stdData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") long id) {
		try {
			stdBusiness.deleteStudent(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

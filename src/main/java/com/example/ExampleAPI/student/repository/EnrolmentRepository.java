package com.example.ExampleAPI.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ExampleAPI.student.model.Enrolment;
import java.util.List;


@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {
	Enrolment findById(long id);
	Enrolment findByStudentId(long id);
	List<Enrolment> findAllByStudentId(long id);
	Enrolment findByCourseId(long id);
	List<Enrolment> findAllByCourseId(long id);
}

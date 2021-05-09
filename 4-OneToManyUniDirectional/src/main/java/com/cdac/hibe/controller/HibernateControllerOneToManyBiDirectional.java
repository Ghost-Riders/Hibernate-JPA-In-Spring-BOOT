/**
 *
 */
package com.cdac.hibe.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.hibe.onetoone.model.Courses;
import com.cdac.hibe.onetoone.model.Instructor;
import com.cdac.hibe.onetoone.repository.CoursesRepository;
import com.cdac.hibe.onetoone.repository.InstructorDetailRepository;
import com.cdac.hibe.onetoone.repository.InstructorRepository;

/**
 * @author Manmath
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class HibernateControllerOneToManyBiDirectional {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	InstructorDetailRepository instructorDetailRepository;

	@Autowired
	InstructorRepository instructorRepository;

	@Autowired
	CoursesRepository coursesRepository;

	@GetMapping("/onetomanydata/{id}")
	public ResponseEntity<?> saveCoursesForInstructorData(@PathVariable("id") int id) {
		Optional<Instructor> instructor = instructorRepository.findById(id);
		if (instructor.isPresent()) {
			Instructor instructor2 = instructor.get();
			LOGGER.info("Instructor Detail: " + instructor2.getInstructorDetail());
			LOGGER.info("Instructor: " + instructor2);
			// create courses
			Courses courses1 = new Courses("Harry Potter.");
			Courses courses2 = new Courses("OnePiece.");

			// add courses to instructor
			instructor.get().add(courses1);
			instructor.get().add(courses2);

			// save course
			coursesRepository.save(courses1);
			coursesRepository.save(courses2);

			return new ResponseEntity<>("Saved", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Data not available...", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getonetomanydata/{id}")
	public ResponseEntity<?> getCoursesData(@PathVariable("id") int id) {
		Optional<Instructor> instructor = instructorRepository.findById(id);
		if (instructor.isPresent()) {
			Instructor instructor2 = instructor.get();
			LOGGER.info("Instructor Detail: " + instructor2.getInstructorDetail());
			LOGGER.info("Instructor: " + instructor2);
			LOGGER.info("Courses: " + instructor2.getCourses());
			return new ResponseEntity<>(instructor2.getCourses(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Data not available...", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/deleteonetomanydata/{id}")
	public ResponseEntity<?> deleteCoursesData(@PathVariable("id") int id) {
		Optional<Courses> courses = coursesRepository.findById(id);
		if (courses.isPresent()) {
			LOGGER.info("Courses: " + courses.get());
			coursesRepository.deleteById(id);
			return new ResponseEntity<>("Deleted...", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Data not available...", HttpStatus.NOT_FOUND);
		}
	}

}

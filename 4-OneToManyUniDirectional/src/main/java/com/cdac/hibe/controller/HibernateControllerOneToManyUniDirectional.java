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
import com.cdac.hibe.onetoone.model.Review;
import com.cdac.hibe.onetoone.repository.CoursesRepository;
import com.cdac.hibe.onetoone.repository.InstructorDetailRepository;
import com.cdac.hibe.onetoone.repository.InstructorRepository;

/**
 * @author Manmath
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class HibernateControllerOneToManyUniDirectional {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	InstructorDetailRepository instructorDetailRepository;

	@Autowired
	InstructorRepository instructorRepository;

	@Autowired
	CoursesRepository coursesRepository;

	@GetMapping("/savecoursereview")
	public ResponseEntity<?> saveCoursesAndReviewData() {

		Courses theCourse = new Courses("Happiness is a lie");

		theCourse.addReview(new Review("Thats not a lie..."));
		theCourse.addReview(new Review("You are right"));
		theCourse.addReview(new Review("May be the way you think"));

		Courses savedCourses = coursesRepository.save(theCourse);
		return new ResponseEntity<>(savedCourses, HttpStatus.OK);
	}

	@GetMapping("/getcoursereview/{id}")
	public ResponseEntity<?> getCoursesData(@PathVariable("id") int id) {
		Optional<Courses> courses = coursesRepository.findById(id);
		if (courses.isPresent()) {
			LOGGER.info("Courses: " + courses.get());
			LOGGER.info("Reviews: " + courses.get().getReviews());
			return new ResponseEntity<>(courses, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Data not available...", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/deletecoursereview/{id}")
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

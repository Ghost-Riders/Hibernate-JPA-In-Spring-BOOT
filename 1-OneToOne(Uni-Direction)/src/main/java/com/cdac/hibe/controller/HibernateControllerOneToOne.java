/**
 *
 */
package com.cdac.hibe.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.hibe.onetoone.model.Instructor;
import com.cdac.hibe.onetoone.model.InstructorDetail;
import com.cdac.hibe.onetoone.repository.InstructorRepository;

/**
 * @author Manmath
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class HibernateControllerOneToOne {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	InstructorRepository instructorRepository;

	@GetMapping("/savedata")
	public String saveData() {
		try {
			InstructorDetail instructorDetail = new InstructorDetail("OnePiece", "Swimming");

			Instructor instructor = new Instructor("Manmath", "Markunde", "manmath@gmail.com");
			instructor.setInstructorDetail(instructorDetail);

			Instructor savedInstructor = instructorRepository.save(instructor);
			if (savedInstructor != null) {
				return "Entity Saved...";
			} else {
				return "Something went wrong.";
			}
		} catch (Exception e) {
			LOGGER.error("Exception Error: " + e.getMessage());
			LOGGER.error("Exception Error: " + e.getLocalizedMessage());
			return "Something went wrong.";
		}
	}

	@GetMapping("/getdata")
	public ResponseEntity<?> getData() {
		try {
			List<Instructor> listInstructor = instructorRepository.findAll();
			if (listInstructor.size() > 0) {
				return new ResponseEntity<>(listInstructor, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Data not available...", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			LOGGER.error("Exception Error: " + e.getMessage());
			LOGGER.error("Exception Error: " + e.getLocalizedMessage());
			return new ResponseEntity<>("Data not available...", HttpStatus.FORBIDDEN);
		}
	}

	@GetMapping("/deletedata")
	public ResponseEntity<?> deleteData() {

		int instructorId = 1;
		Optional<Instructor> instructor = instructorRepository.findById(instructorId);
		if (instructor.isPresent()) {
			instructorRepository.deleteById(instructorId);
			return new ResponseEntity<>("Data Deleted: " + instructor.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Something went wrong...", HttpStatus.NOT_FOUND);
		}
	}

}

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

import com.cdac.hibe.onetoone.model.InstructorDetail;
import com.cdac.hibe.onetoone.repository.InstructorDetailRepository;

/**
 * @author Manmath
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class HibernateControllerOneToOneBiDirectional {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	InstructorDetailRepository instructorDetailRepository;

	@GetMapping("/sgetsingledata/{id}")
	public ResponseEntity<?> getSingleData(@PathVariable("id") int id) {
		Optional<InstructorDetail> instructorDetail = instructorDetailRepository.findById(id);
		if (instructorDetail.isPresent()) {
			InstructorDetail ids = instructorDetail.get();
			LOGGER.info("Instructor Detail: " + ids);
			LOGGER.info("Instructor: " + instructorDetail.get().getInstructor());
			return new ResponseEntity<>(instructorDetail.get().getInstructor(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Data not available...", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/sdeletesingledata/{id}")
	public ResponseEntity<?> deleteSingleData(@PathVariable("id") int id) {
		Optional<InstructorDetail> instructorDetail = instructorDetailRepository.findById(id);
		if (instructorDetail.isPresent()) {

			// ***********************************************************
			// removed the associated object reference break bi-directional link
			instructorDetail.get().getInstructor().setInstructorDetail(null);
			// ***********************************************************

			instructorDetailRepository.deleteById(id);
			LOGGER.info("Instructor: " + instructorDetail.get().getInstructor());
			return new ResponseEntity<>("Deleted Successfully...", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Data not available...", HttpStatus.NOT_FOUND);
		}
	}

}

package com.Demo.OneToManyBiDirectional.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Demo.OneToManyBiDirectional.customException.SubjectNotFoundException;
import com.Demo.OneToManyBiDirectional.model.Subject;
import com.Demo.OneToManyBiDirectional.service.SubjectService;

import net.bytebuddy.asm.Advice.This;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class SubjectController {

	private static final Logger LOGGER = LoggerFactory.getLogger(This.class);

	@Autowired
	SubjectService subjectService;

	@PostMapping(path = "/subject/save")
	public ResponseEntity<?> saveStudentAndAddressDetail(@RequestBody Subject subject) {
		// save StudentAddress
		/*
		 * sample Input Body [Request Body ]: { "officeName": "CDAC", "officeAddress":
		 * "Noida" }
		 */
		// NOTE: THIS WILL ONLY STORED MAPPED OBJEST , TO STORE ALL THE MAPPED AND
		// ASSOCIATED OBJECT USE STUDENT POST URL
		Subject savedStudentAddress = subjectService.saveSubject(subject);

		if (savedStudentAddress != null) {
			return new ResponseEntity<>(savedStudentAddress, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Something went wrong, Try again after sometime...", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/subject/{id}")
	public ResponseEntity<?> getStudentAndAddressDetailById(@PathVariable("id") int id) {
		// Retrieve StudentAddresss
		Optional<Subject> subject = subjectService.getSubject(id);

		if (subject.isPresent()) {
			LOGGER.info("Student Address: " + subject.get());
			LOGGER.info("Student : " + subject.get().getStudent());
			return new ResponseEntity<>(subject.get(), HttpStatus.OK);
		} else {
			// return new ResponseEntity<>("Something went wrong, Try again after
			// sometime...", HttpStatus.NOT_FOUND);
			throw new SubjectNotFoundException("StudentAddress not available: " + id);
		}
	}

	@DeleteMapping("/subject/{id}")
	public ResponseEntity<?> deleteStudentAndAddressDetailById(@PathVariable("id") int id) {
		// Retrieve StudentAddresss
		Optional<Subject> subject = subjectService.getSubject(id);

		if (subject.isPresent()) {

			// remove associate reference before deleting
			subject.get().getStudent().setSubject(null);
			// *************

			subjectService.deleteSubject(id);
			return new ResponseEntity<>(subject.get(), HttpStatus.OK);
		} else {
			// return new ResponseEntity<>("Something went wrong, Try again after
			// sometime...", HttpStatus.NOT_FOUND);
			throw new SubjectNotFoundException("StudentAddress Not Found : " + id);
		}
	}

	@GetMapping("/subject")
	public ResponseEntity<?> getListOfStudentAndAddressDetail() {
		// Retrieve StudentAddresss
		List<Subject> subject = subjectService.subjects();

		if (subject.size() > 0) {
			return new ResponseEntity<>(subject, HttpStatus.OK);
		} else {
			// return new ResponseEntity<>("Something went wrong, Try again after
			// sometime...", HttpStatus.NOT_FOUND);
			throw new SubjectNotFoundException("StudentAddresss Not Available");
		}
	}
	/*
	 * @ExceptionHandler public ResponseEntity<?>
	 * handleException(StudentAddressNotFoundException exc) {
	 * StudentAddressErrorResponse error = new StudentAddressErrorResponse();
	 * 
	 * error.setStatus(HttpStatus.NOT_FOUND.value());
	 * error.setMessage(exc.getMessage());
	 * error.setTimeStamp(System.currentTimeMillis());
	 * 
	 * return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); }
	 * 
	 * @ExceptionHandler public ResponseEntity<?> handleException(Exception exc) {
	 * StudentAddressErrorResponse error = new StudentAddressErrorResponse();
	 * 
	 * error.setStatus(HttpStatus.BAD_REQUEST.value());
	 * error.setMessage(exc.getMessage());
	 * error.setTimeStamp(System.currentTimeMillis());
	 * 
	 * return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); }
	 */
}

package com.Demo.OneToOneBiDirectional.controller;

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

import com.Demo.OneToOneBiDirectional.customException.StudentAddressNotFoundException;
import com.Demo.OneToOneBiDirectional.model.StudentAddress;
import com.Demo.OneToOneBiDirectional.service.StudentAddressService;

import net.bytebuddy.asm.Advice.This;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class StudentAddressController {

	private static final Logger LOGGER = LoggerFactory.getLogger(This.class);

	@Autowired
	StudentAddressService studentAddressService;

	@PostMapping(path = "/studentAddress/save")
	public ResponseEntity<?> saveStudentAndAddressDetail(@RequestBody StudentAddress studentAddress) {
		// save StudentAddress
		/*
		 * sample Input Body [Request Body ]: { "officeName": "CDAC", "officeAddress":
		 * "Noida" }
		 */
		// NOTE: THIS WILL ONLY STORED MAPPED OBJEST , TO STORE ALL THE MAPPED AND
		// ASSOCIATED OBJECT USE STUDENT POST URL
		StudentAddress savedStudentAddress = studentAddressService.saveStudentAddress(studentAddress);

		if (savedStudentAddress != null) {
			return new ResponseEntity<>(savedStudentAddress, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Something went wrong, Try again after sometime...", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/studentAddress/{id}")
	public ResponseEntity<?> getStudentAndAddressDetailById(@PathVariable("id") int id) {
		// Retrieve StudentAddresss
		Optional<StudentAddress> studentAddress = studentAddressService.getStudentAddress(id);

		if (studentAddress.isPresent()) {
			LOGGER.info("Student Address: " + studentAddress.get());
			LOGGER.info("Student : " + studentAddress.get().getStudent());
			return new ResponseEntity<>(studentAddress.get(), HttpStatus.OK);
		} else {
			// return new ResponseEntity<>("Something went wrong, Try again after
			// sometime...", HttpStatus.NOT_FOUND);
			throw new StudentAddressNotFoundException("StudentAddress not available: " + id);
		}
	}

	@DeleteMapping("/studentAddress/{id}")
	public ResponseEntity<?> deleteStudentAndAddressDetailById(@PathVariable("id") int id) {
		// Retrieve StudentAddresss
		Optional<StudentAddress> studentAddress = studentAddressService.getStudentAddress(id);

		if (studentAddress.isPresent()) {

			// remove associate reference before deleting
			studentAddress.get().getStudent().setStudentAddress(null);
			// *************

			studentAddressService.deleteStudentAddress(id);
			return new ResponseEntity<>(studentAddress.get(), HttpStatus.OK);
		} else {
			// return new ResponseEntity<>("Something went wrong, Try again after
			// sometime...", HttpStatus.NOT_FOUND);
			throw new StudentAddressNotFoundException("StudentAddress Not Found : " + id);
		}
	}

	@GetMapping("/studentAddress")
	public ResponseEntity<?> getListOfStudentAndAddressDetail() {
		// Retrieve StudentAddresss
		List<StudentAddress> studentAddress = studentAddressService.studentAddresss();

		if (studentAddress.size() > 0) {
			return new ResponseEntity<>(studentAddress, HttpStatus.OK);
		} else {
			// return new ResponseEntity<>("Something went wrong, Try again after
			// sometime...", HttpStatus.NOT_FOUND);
			throw new StudentAddressNotFoundException("StudentAddresss Not Available");
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

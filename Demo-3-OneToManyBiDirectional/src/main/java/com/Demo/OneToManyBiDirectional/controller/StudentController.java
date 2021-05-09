package com.Demo.OneToManyBiDirectional.controller;

import java.util.List;
import java.util.Optional;

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

import com.Demo.OneToManyBiDirectional.customException.StudentNotFoundException;
import com.Demo.OneToManyBiDirectional.model.Student;
import com.Demo.OneToManyBiDirectional.service.StudentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping(path = "/student/save")
	public ResponseEntity<?> saveStudentAndOfficeDetail(@RequestBody Student student) {
		// save Student
		/*
		 * { "studentName": "Manmath", "studentRollNo": "111150140", "studentAddress": {
		 * "pinCode": "431750", "address": "Pune" } }
		 */
		Student savedStudent = studentService.saveStudent(student);

		if (savedStudent != null) {
			return new ResponseEntity<>(savedStudent, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Something went wrong, Try again after sometime...", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<?> getStudentAndOfficeDetailById(@PathVariable("id") int id) {
		// Retrieve Students
		Optional<Student> student = studentService.getStudent(id);

		if (student.isPresent()) {
			return new ResponseEntity<>(student.get(), HttpStatus.OK);
		} else {
			// return new ResponseEntity<>("Something went wrong, Try again after
			// sometime...", HttpStatus.NOT_FOUND);
			throw new StudentNotFoundException("Student not available: " + id);
		}
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<?> deleteStudentAndOfficeDetailById(@PathVariable("id") int id) {
		// Retrieve Students
		Optional<Student> student = studentService.getStudent(id);

		if (student.isPresent()) {
			studentService.deleteStudent(id);
			return new ResponseEntity<>(student.get(), HttpStatus.OK);
		} else {
			// return new ResponseEntity<>("Something went wrong, Try again after
			// sometime...", HttpStatus.NOT_FOUND);
			throw new StudentNotFoundException("Student Not Found : " + id);
		}
	}

	@GetMapping("/students")
	public ResponseEntity<?> getListOfStudentAndOfficeDetail() {
		// Retrieve Students
		List<Student> students = studentService.students();

		if (students.size() > 0) {
			return new ResponseEntity<>(students, HttpStatus.OK);
		} else {
			// return new ResponseEntity<>("Something went wrong, Try again after
			// sometime...", HttpStatus.NOT_FOUND);
			throw new StudentNotFoundException("Students Not Available");
		}
	}
	/*
	 * @ExceptionHandler public ResponseEntity<?>
	 * handleException(StudentNotFoundException exc) { StudentErrorResponse error =
	 * new StudentErrorResponse();
	 * 
	 * error.setStatus(HttpStatus.NOT_FOUND.value());
	 * error.setMessage(exc.getMessage());
	 * error.setTimeStamp(System.currentTimeMillis());
	 * 
	 * return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); }
	 * 
	 * @ExceptionHandler public ResponseEntity<?> handleException(Exception exc) {
	 * StudentErrorResponse error = new StudentErrorResponse();
	 * 
	 * error.setStatus(HttpStatus.BAD_REQUEST.value());
	 * error.setMessage(exc.getMessage());
	 * error.setTimeStamp(System.currentTimeMillis());
	 * 
	 * return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); }
	 */
}

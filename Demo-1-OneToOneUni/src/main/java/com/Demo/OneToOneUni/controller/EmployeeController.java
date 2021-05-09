package com.Demo.OneToOneUni.controller;

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

import com.Demo.OneToOneUni.customException.EmployeeNotFoundException;
import com.Demo.OneToOneUni.model.Employee;
import com.Demo.OneToOneUni.service.EmployeeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping(path = "/employee/save")
	public ResponseEntity<?> saveEmployeeAndOfficeDetail(@RequestBody Employee employee) {
		// save employee
		/*
		 * sample Input Body [Request Body ]: { "employeeName": "Manmath",
		 * "employeeAddress": "Nanded", "employeeOffice": { "officeName": "CDAC",
		 * "officeAddress": "Noida" } }
		 */
		Employee savedEmployee = employeeService.saveEmployee(employee);

		if (savedEmployee != null) {
			return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Something went wrong, Try again after sometime...", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> getEmployeeAndOfficeDetailById(@PathVariable("id") int id) {
		// Retrieve Employees
		Optional<Employee> employee = employeeService.getEmployee(id);

		if (employee.isPresent()) {
			return new ResponseEntity<>(employee.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Something went wrong, Try again after sometime...", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<?> deleteEmployeeAndOfficeDetailById(@PathVariable("id") int id) {
		// Retrieve Employees
		Optional<Employee> employee = employeeService.getEmployee(id);

		if (employee.isPresent()) {
			employeeService.deleteEmployee(id);
			return new ResponseEntity<>(employee.get(), HttpStatus.OK);
		} else {
			// return new ResponseEntity<>("Something went wrong, Try again after
			// sometime...", HttpStatus.NOT_FOUND);
			throw new EmployeeNotFoundException("Employee Not Found : " + id);
		}
	}

	@GetMapping("/employees")
	public ResponseEntity<?> getListOfEmployeeAndOfficeDetail() {
		// Retrieve Employees
		List<Employee> employees = employeeService.employees();

		if (employees.size() > 0) {
			return new ResponseEntity<>(employees, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Something went wrong, Try again after sometime...", HttpStatus.NOT_FOUND);
		}
	}
	/*
	 * @ExceptionHandler public ResponseEntity<?>
	 * handleException(EmployeeNotFoundException exc) { EmployeeErrorResponse error
	 * = new EmployeeErrorResponse();
	 * 
	 * error.setStatus(HttpStatus.NOT_FOUND.value());
	 * error.setMessage(exc.getMessage());
	 * error.setTimeStamp(System.currentTimeMillis());
	 * 
	 * return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); }
	 * 
	 * @ExceptionHandler public ResponseEntity<?> handleException(Exception exc) {
	 * EmployeeErrorResponse error = new EmployeeErrorResponse();
	 * 
	 * error.setStatus(HttpStatus.BAD_REQUEST.value());
	 * error.setMessage(exc.getMessage());
	 * error.setTimeStamp(System.currentTimeMillis());
	 * 
	 * return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); }
	 */
}

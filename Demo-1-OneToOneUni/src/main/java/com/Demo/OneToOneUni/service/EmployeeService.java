package com.Demo.OneToOneUni.service;

import java.util.List;
import java.util.Optional;

import com.Demo.OneToOneUni.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	Optional<Employee> getEmployee(int id);

	Employee deleteEmployee(int id);

	List<Employee> employees();
}

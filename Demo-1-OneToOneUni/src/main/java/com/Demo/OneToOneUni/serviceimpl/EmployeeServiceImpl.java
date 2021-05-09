package com.Demo.OneToOneUni.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Demo.OneToOneUni.model.Employee;
import com.Demo.OneToOneUni.repository.EmployeeRepository;
import com.Demo.OneToOneUni.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> getEmployee(int id) {
		return employeeRepository.findById(id);
	}

	@Override
	public Employee deleteEmployee(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			employeeRepository.deleteById(id);
			return employee.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Employee> employees() {
		return employeeRepository.findAll();
	}

}

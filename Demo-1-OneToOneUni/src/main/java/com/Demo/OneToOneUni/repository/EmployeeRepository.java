package com.Demo.OneToOneUni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.OneToOneUni.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

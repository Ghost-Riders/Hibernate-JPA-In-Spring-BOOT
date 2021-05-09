package com.Demo.OneToManyBiDirectional.service;

import java.util.List;
import java.util.Optional;

import com.Demo.OneToManyBiDirectional.model.Student;

public interface StudentService {

	Student saveStudent(Student student);

	Optional<Student> getStudent(int id);

	Student deleteStudent(int id);

	List<Student> students();
}

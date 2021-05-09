package com.Demo.OneToOneBiDirectional.service;

import java.util.List;
import java.util.Optional;

import com.Demo.OneToOneBiDirectional.model.StudentAddress;

public interface StudentAddressService {

	StudentAddress saveStudentAddress(StudentAddress StudentAddress);

	Optional<StudentAddress> getStudentAddress(int id);

	StudentAddress deleteStudentAddress(int id);

	List<StudentAddress> studentAddresss();
}

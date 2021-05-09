package com.Demo.OneToOneBiDirectional.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Demo.OneToOneBiDirectional.model.StudentAddress;
import com.Demo.OneToOneBiDirectional.repository.StudentAddressRepository;
import com.Demo.OneToOneBiDirectional.service.StudentAddressService;

@Service
public class StudentAddressServiceImpl implements StudentAddressService {

	@Autowired
	StudentAddressRepository studentAddressRepository;

	@Override
	public StudentAddress saveStudentAddress(StudentAddress studentAddress) {
		return studentAddressRepository.save(studentAddress);
	}

	@Override
	public Optional<StudentAddress> getStudentAddress(int id) {
		return studentAddressRepository.findById(id);
	}

	@Override
	public StudentAddress deleteStudentAddress(int id) {
		Optional<StudentAddress> studentAddress = studentAddressRepository.findById(id);
		if (studentAddress.isPresent()) {
			studentAddressRepository.deleteById(id);
			return studentAddress.get();
		} else {
			return null;
		}
	}

	@Override
	public List<StudentAddress> studentAddresss() {
		return studentAddressRepository.findAll();
	}

}

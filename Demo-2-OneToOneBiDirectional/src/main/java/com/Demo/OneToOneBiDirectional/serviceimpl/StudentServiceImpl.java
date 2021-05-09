package com.Demo.OneToOneBiDirectional.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Demo.OneToOneBiDirectional.model.Student;
import com.Demo.OneToOneBiDirectional.repository.StudentRepository;
import com.Demo.OneToOneBiDirectional.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Optional<Student> getStudent(int id) {
		return studentRepository.findById(id);
	}

	@Override
	public Student deleteStudent(int id) {
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			studentRepository.deleteById(id);
			return student.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Student> students() {
		return studentRepository.findAll();
	}

}

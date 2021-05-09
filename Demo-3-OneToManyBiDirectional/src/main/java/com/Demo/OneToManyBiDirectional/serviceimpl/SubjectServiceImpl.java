package com.Demo.OneToManyBiDirectional.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Demo.OneToManyBiDirectional.model.Subject;
import com.Demo.OneToManyBiDirectional.repository.SubjectRepository;
import com.Demo.OneToManyBiDirectional.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectRepository subjectRepository;

	@Override
	public Subject saveSubject(Subject subject) {
		return subjectRepository.save(subject);
	}

	@Override
	public Optional<Subject> getSubject(int id) {
		return subjectRepository.findById(id);
	}

	@Override
	public Subject deleteSubject(int id) {
		Optional<Subject> subject = subjectRepository.findById(id);
		if (subject.isPresent()) {
			subjectRepository.deleteById(id);
			return subject.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Subject> subjects() {
		return subjectRepository.findAll();
	}

}

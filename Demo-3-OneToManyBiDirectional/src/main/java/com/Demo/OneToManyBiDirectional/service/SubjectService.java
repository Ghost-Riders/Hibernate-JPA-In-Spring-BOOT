package com.Demo.OneToManyBiDirectional.service;

import java.util.List;
import java.util.Optional;

import com.Demo.OneToManyBiDirectional.model.Subject;

public interface SubjectService {

	Subject saveSubject(Subject Subject);

	Optional<Subject> getSubject(int id);

	Subject deleteSubject(int id);

	List<Subject> subjects();
}

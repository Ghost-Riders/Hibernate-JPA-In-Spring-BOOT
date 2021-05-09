package com.Demo.ManyToMany.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Demo.ManyToMany.model.Developer;
import com.Demo.ManyToMany.repository.DeveloperRepository;
import com.Demo.ManyToMany.service.DeveloperService;

@Service
public class DeveloperServiceImpl implements DeveloperService {

	@Autowired
	DeveloperRepository developerRepository;

	@Override
	public Developer saveDeveloper(Developer developer) {
		return developerRepository.save(developer);
	}

	@Override
	public Optional<Developer> getDeveloper(int id) {
		return developerRepository.findById(id);
	}

	@Override
	public Developer deleteDeveloper(int id) {
		Optional<Developer> developer = developerRepository.findById(id);
		if (developer.isPresent()) {
			developerRepository.deleteById(id);
			return developer.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Developer> developers() {
		return developerRepository.findAll();
	}

}

package com.Demo.ManyToMany.service;

import java.util.List;
import java.util.Optional;

import com.Demo.ManyToMany.model.Developer;

public interface DeveloperService {

	Developer saveDeveloper(Developer developer);

	Optional<Developer> getDeveloper(int id);

	Developer deleteDeveloper(int id);

	List<Developer> developers();
}

package com.Demo.ManyToMany.service;

import java.util.List;
import java.util.Optional;

import com.Demo.ManyToMany.model.Skill;

public interface SkillService {

	Skill saveSkill(Skill skill);

	Optional<Skill> getSkill(int id);

	Skill deleteSkill(int id);

	List<Skill> skills();
}

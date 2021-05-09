package com.Demo.ManyToMany.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Demo.ManyToMany.model.Skill;
import com.Demo.ManyToMany.repository.SkillRepository;
import com.Demo.ManyToMany.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	SkillRepository skillRepository;

	@Override
	public Skill saveSkill(Skill skill) {
		return skillRepository.save(skill);
	}

	@Override
	public Optional<Skill> getSkill(int id) {
		return skillRepository.findById(id);
	}

	@Override
	public Skill deleteSkill(int id) {
		Optional<Skill> skill = skillRepository.findById(id);
		if (skill.isPresent()) {
			skillRepository.deleteById(id);
			return skill.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Skill> skills() {
		return skillRepository.findAll();
	}

}

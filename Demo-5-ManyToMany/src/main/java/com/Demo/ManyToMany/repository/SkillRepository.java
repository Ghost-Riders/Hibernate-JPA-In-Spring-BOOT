package com.Demo.ManyToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.ManyToMany.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

}

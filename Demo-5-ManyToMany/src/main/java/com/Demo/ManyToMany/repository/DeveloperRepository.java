package com.Demo.ManyToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.ManyToMany.model.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Integer> {

}

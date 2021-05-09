package com.Demo.OneToManyUniDirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.OneToManyUniDirectional.model.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Integer> {

}

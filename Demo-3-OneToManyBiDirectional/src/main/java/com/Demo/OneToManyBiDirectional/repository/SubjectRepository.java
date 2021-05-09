package com.Demo.OneToManyBiDirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.OneToManyBiDirectional.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}

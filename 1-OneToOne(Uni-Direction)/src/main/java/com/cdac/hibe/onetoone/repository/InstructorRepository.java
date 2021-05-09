package com.cdac.hibe.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.hibe.onetoone.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}

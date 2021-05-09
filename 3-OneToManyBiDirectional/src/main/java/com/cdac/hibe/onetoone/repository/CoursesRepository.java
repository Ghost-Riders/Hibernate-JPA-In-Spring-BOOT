package com.cdac.hibe.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.hibe.onetoone.model.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {
}

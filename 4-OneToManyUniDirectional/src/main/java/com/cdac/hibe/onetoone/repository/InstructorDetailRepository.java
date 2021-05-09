package com.cdac.hibe.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.hibe.onetoone.model.InstructorDetail;

public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Integer> {
// here, instructorDetail pojo is used for bi-directional package 
}

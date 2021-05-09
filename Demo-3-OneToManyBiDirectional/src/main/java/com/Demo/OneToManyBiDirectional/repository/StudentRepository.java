package com.Demo.OneToManyBiDirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.OneToManyBiDirectional.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

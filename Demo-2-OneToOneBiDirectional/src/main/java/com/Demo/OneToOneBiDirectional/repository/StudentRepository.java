package com.Demo.OneToOneBiDirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.OneToOneBiDirectional.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

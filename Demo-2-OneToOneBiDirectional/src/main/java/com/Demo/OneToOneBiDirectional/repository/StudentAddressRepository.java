package com.Demo.OneToOneBiDirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.OneToOneBiDirectional.model.StudentAddress;

public interface StudentAddressRepository extends JpaRepository<StudentAddress, Integer> {

}

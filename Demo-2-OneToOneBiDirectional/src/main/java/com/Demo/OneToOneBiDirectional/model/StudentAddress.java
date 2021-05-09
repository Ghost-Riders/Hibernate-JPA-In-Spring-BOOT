package com.Demo.OneToOneBiDirectional.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "StudentAddress", schema = "oneToOneBiDirection")
public class StudentAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@Column(name = "PinCode")
	private String pinCode;

	@Column(name = "Address")
	private String address;

	@OneToOne(mappedBy = "studentAddress")
	@JsonBackReference
	private Student student;

	public StudentAddress() {

	}

	public StudentAddress(String pinCode, String address) {
		this.pinCode = pinCode;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentAddress [id=" + id + ", pinCode=" + pinCode + ", Address=" + address + "]";
	}

}

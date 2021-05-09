package com.Demo.OneToOneBiDirectional.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Student", schema = "oneToOneBiDirection")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;

	@Column(name = "studentName")
	private String studentName;

	@Column(name = "studentRollNo")
	private String studentRollNo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "studentAddressId")
	@JsonManagedReference
	private StudentAddress studentAddress;

	public Student() {

	}

	public Student(String studentName, String studentRollNo) {
		this.studentName = studentName;
		this.studentRollNo = studentRollNo;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentRollNo() {
		return studentRollNo;
	}

	public void setStudentRollNo(String studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

	public StudentAddress getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(StudentAddress studentAddress) {
		this.studentAddress = studentAddress;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", studentName=" + studentName + ", studentRollNo=" + studentRollNo + "]";
	}

}

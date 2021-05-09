package com.Demo.OneToManyBiDirectional.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Student", schema = "oneToManyBiDirection")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "studentName")
	private String studentName;

	@Column(name = "studentRollNo")
	private String studentRollNo;

	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Subject> subject;

	public Student() {

	}

	public Student(String studentName, String studentRollNo) {
		this.studentName = studentName;
		this.studentRollNo = studentRollNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student [Id=" + id + ", studentName=" + studentName + ", studentRollNo=" + studentRollNo + "]";
	}

}

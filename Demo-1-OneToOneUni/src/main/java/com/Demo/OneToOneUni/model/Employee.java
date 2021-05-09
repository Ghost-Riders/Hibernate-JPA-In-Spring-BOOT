package com.Demo.OneToOneUni.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee", schema = "oneToOneUniDirection")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;

	@Column(name = "employeeName")
	private String employeeName;

	@Column(name = "employeeAddress")
	private String employeeAddress;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeOfficeId")
	private EmployeeOffice employeeOffice;

	public Employee() {

	}

	public Employee(String employeeName, String employeeAddress) {
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public EmployeeOffice getEmployeeOffice() {
		return employeeOffice;
	}

	public void setEmployeeOffice(EmployeeOffice employeeOffice) {
		this.employeeOffice = employeeOffice;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", employeeName=" + employeeName + ", employeeAddress=" + employeeAddress + "]";
	}

}

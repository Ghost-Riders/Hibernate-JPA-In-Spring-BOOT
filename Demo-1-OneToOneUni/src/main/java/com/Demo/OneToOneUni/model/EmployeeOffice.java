package com.Demo.OneToOneUni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeOffice", schema = "oneToOneUniDirection")
public class EmployeeOffice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@Column(name = "officeName")
	private String officeName;

	@Column(name = "officeAddress")
	private String officeAddress;

	public EmployeeOffice() {

	}

	public EmployeeOffice(String officeName, String officeAddress) {
		this.officeName = officeName;
		this.officeAddress = officeAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	@Override
	public String toString() {
		return "EmployeeOffice [id=" + id + ", officeName=" + officeName + ", officeAddress=" + officeAddress + "]";
	}
}

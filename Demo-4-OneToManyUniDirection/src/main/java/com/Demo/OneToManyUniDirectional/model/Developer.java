package com.Demo.OneToManyUniDirectional.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Developer", schema = "oneToManyUniDirection")
public class Developer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "developerName")
	private String developerName;

	@Column(name = "developerExperience")
	private String developerExperience;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "technologyId")
	private List<Skill> skill;

	public Developer() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public String getDeveloperExperience() {
		return developerExperience;
	}

	public void setDeveloperExperience(String developerExperience) {
		this.developerExperience = developerExperience;
	}

	public List<Skill> getSkill() {
		return skill;
	}

	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Developer [id=" + id + ", developerName=" + developerName + ", developerExperience="
				+ developerExperience + "]";
	}

}

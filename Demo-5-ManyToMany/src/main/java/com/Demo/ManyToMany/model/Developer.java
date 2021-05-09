package com.Demo.ManyToMany.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Developer", schema = "ManyToMany")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Developer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "developerName")
	private String developerName;

	@Column(name = "developerExperience")
	private String developerExperience;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinTable(schema = "ManyToMany", name = "developerSkillSet", joinColumns = @JoinColumn(name = "developerId"), inverseJoinColumns = @JoinColumn(name = "skillId"))
	private List<Skill> skills;

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
		return skills;
	}

	public void setSkill(List<Skill> skill) {
		this.skills = skill;
	}

	@Override
	public String toString() {
		return "Developer [id=" + id + ", developerName=" + developerName + ", developerExperience="
				+ developerExperience + "]";
	}

}

package com.rs.eis.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "experience")
@EntityListeners(AuditingEntityListener.class)
public class Experience {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int totalexperience;
	private int relevantexperience;
	private int employeeid;
	private int employerid;
	private int technologyid;

	private Date created;
	private Date updated;

	public Experience() {
	}

	public Experience(int id, int totalexperience, int relevantexperience, int employeeid, int employerid,
			int technologyid) {

		this.id = id;
		this.totalexperience = totalexperience;
		this.relevantexperience = relevantexperience;
		this.employeeid = employeeid;
		this.employerid = employerid;
		this.technologyid = technologyid;

	}

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalexperience() {
		return totalexperience;
	}

	public void setTotalexperience(int totalexperience) {
		this.totalexperience = totalexperience;
	}

	public int getRelevantexperience() {
		return relevantexperience;
	}

	public void setRelevantexperience(int relevantexperience) {
		this.relevantexperience = relevantexperience;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public int getEmployerid() {
		return employerid;
	}

	public void setEmployerid(int employerid) {
		this.employerid = employerid;
	}

	public int getTechnologyid() {
		return technologyid;
	}

	public void setTechnologyid(int technologyid) {
		this.technologyid = technologyid;
	}

	@Override
	public String toString() {
		return "Experience [userid=" + id + ", totalexperience=" + totalexperience + ", relevantexperience="
				+ relevantexperience + ", employeeid=" + employeeid + ", employerid=" + employerid + ", technologyid="
				+ technologyid + "]";
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
}

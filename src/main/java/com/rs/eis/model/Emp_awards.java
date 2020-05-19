package com.rs.eis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "emp_awards")
@EntityListeners(AuditingEntityListener.class)

public class Emp_awards {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String name;
	private String date;
	private int employeeid;
	private int awardsid;
	//private Date created;
	//private Date updated;
	
	

	public Emp_awards() {

	}

	public Emp_awards(int id, String date, String name, int employeeid, int awardsid) {

		this.id = id;
		this.name = name;
		this.date = date;
		this.employeeid = employeeid;
		this.awardsid = awardsid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getdate() {
		return date;
	}

	public void setdate(String date) {
		this.date = date;
	}

	public int getemployeeid() {
		return employeeid;
	}

	public void setemployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public int getawardsid() {
		return awardsid;
	}

	public void setawardsid(int awardsid) {
		this.awardsid = awardsid;
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

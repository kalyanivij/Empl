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
@Table(name="circle")
@EntityListeners(AuditingEntityListener.class)
public class Circle {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String other;
	private int employerid;
	private Date created;
	private Date updated;
	
	
	public Circle() {
		
	}


	public Circle(int id, String name, String other, int employerid, Date created, Date updated) {
		super();
		this.id = id;
		this.name = name;
		this.other = other;
		this.employerid = employerid;
		this.created = created;
		this.updated = updated;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOther() {
		return other;
	}


	public void setOther(String other) {
		this.other = other;
	}


	public int getEmployerid() {
		return employerid;
	}


	public void setEmployerid(int employerid) {
		this.employerid = employerid;
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

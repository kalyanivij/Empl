package com.rs.fer.model;

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
@Table(name = "Pf")
@EntityListeners(AuditingEntityListener.class)

public class Pf {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private int amount;
	private String peroidDate;
	private int employeeid;
	private int employerid;
	private Date created;
	private Date updated;

	public Pf() {

	}

	public Pf(int id, int amount, String peroidDate, int employeeid, int employerid) {
		super();
		this.id = id;
		this.amount = amount;
		this.peroidDate = peroidDate;
		this.employeeid = employeeid;
		this.employerid = employerid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPeroidDate() {
		return peroidDate;
	}

	public void setPeroidDate(String peroidDate) {
		this.peroidDate = peroidDate;
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

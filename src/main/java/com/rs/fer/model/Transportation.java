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
@Table(name = "transportation")
@EntityListeners(AuditingEntityListener.class)

public class Transportation {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private String exceptedTimeToTravel;
	private int allowanceid;
	private Date created;
	private Date updated;

	public Transportation() {

	}

	public Transportation(int id, String type, String exceptedTimeToTravel, int allowanceid) {
		super();
		this.id = id;
		this.type = type;
		this.exceptedTimeToTravel = exceptedTimeToTravel;
		this.allowanceid = allowanceid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExceptedTimeToTravel() {
		return exceptedTimeToTravel;
	}

	public void setExceptedTimeToTravel(String exceptedTimeToTravel) {
		this.exceptedTimeToTravel = exceptedTimeToTravel;
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

	public int getAllowanceid() {
		return allowanceid;
	}

	public void setAllowanceid(int allowanceid) {
		this.allowanceid = allowanceid;
	}

}

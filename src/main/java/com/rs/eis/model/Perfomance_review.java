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
@Table(name = "perfomance_review")
@EntityListeners(AuditingEntityListener.class)

public class Perfomance_review {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String date;
	private int employeeid;
	private int reviewid;
	private Date created;
	private Date updated;

	public Perfomance_review() {

	}

	public Perfomance_review(int id, String date, int employeeid, int reviewid) {

		this.id = id;
		
		this.date = date;
		
		this.employeeid = employeeid;
		
		this.reviewid = reviewid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getreviewid() {
		return reviewid;
	}

	public void setreviewid(int reviewid) {
		this.reviewid = reviewid;
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

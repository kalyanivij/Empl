package com.rs.eis.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Leave_Data")
public class Leave_Data{

	
	@Id
	@Column(updatable = false, nullable = false)
	@GeneratedValue
	private int id;	
	private Date date;
	private String added;
	private String  taken;
	private int balance;	
	private int employeeid;
	private Date created;
	private Date updated;

	
	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}


	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAdded() {
		return added;
	}

	public void setAdded(String added) {
		this.added = added;
	}

	public String getTaken() {
		return taken;
	}

	public void setTaken(String taken) {
		this.taken = taken;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	

	public Leave_Data() {

	}

	public Leave_Data(int id, Date date, String added) {

		this.id = id;
		this.date = date;
		this.added = added;

	}

	
}

package com.rs.eis.request;

import java.util.Date;

public class AddDepartmentVO {
	private int id;
	private String name;
	private int employerid;
	private Date created;
	private Date updated;
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

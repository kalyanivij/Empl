package com.rs.eis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "emp_designation")
@EntityListeners(AuditingEntityListener.class)

public class Emp_Designation {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int startDate;
	private int endDate;          
	private int designationid;
	private int employeeid;
	private int employerid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStartDate() {
		return startDate;
	}
	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}
	public int getEndDate() {
		return endDate;
	}
	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}
	public int getDesignationid() {
		return designationid;
	}
	public void setDesignationid(int designationid) {
		this.designationid = designationid;
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

	
}

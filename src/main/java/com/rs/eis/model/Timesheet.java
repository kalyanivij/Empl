package com.rs.eis.model;

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
@Table(name = "Timesheet")
@EntityListeners(AuditingEntityListener.class)
public class Timesheet {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String day;
	private String inTime;
	private String outTime;
	private int employeeId;
	private int departmentId;
	private int allocationId;

	public Timesheet() {

	}

	public Timesheet(int id, String day, String inTime, String outTime, int employeeId, int departmentId, int allocationId) {

		this.id = id;
		this.day = day;
		this.inTime = inTime;
		this.outTime = outTime;
		this.employeeId = employeeId;
		this.departmentId = departmentId;
		this.allocationId = allocationId;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Allocations allocation;

	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
	}

	public int getAllocationId() {
		return allocationId;
	}

	public int getId() {
		return id;
	}

	public void setTid(int id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

}

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
@Table(name = "insurance")
@EntityListeners(AuditingEntityListener.class)
public class Insurance {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int amount;
	private String startDate;
	private String endDate;
	private int insuranceId;
	private int employeeId;
	private Date created;
	private Date updated;
	public Insurance(int id, int amount, String startDate, String endDate,int insuranceId, int employeeId) {

		this.id = id;
		this.amount = amount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.insuranceId=insuranceId;
		this.employeeId = employeeId;
	}

	public int getInsuranceid() {
		return insuranceId;
	}

	public void setInsuranceid(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public Insurance() {
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEnddDate(String endDate) {
		this.endDate = endDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}

		
}

package com.rs.eis.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "contact")
@EntityListeners(AuditingEntityListener.class)
public class Contact {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String countryCode;
	private String value;
	private String type;
	private Date created;
	private Date updated;

	public Contact() {
	}

	public Contact(int id, String countryCode, String value, String type, Date created, Date updated, Employee employee,
			Employer employer) {

		this.id = id;
		this.countryCode = countryCode;
		this.value = value;
		this.type = type;
		this.created = created;
		this.updated = updated;
		this.employee = employee;
		this.employer = employer;

	}

	@OneToOne(targetEntity = Employee.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeid", referencedColumnName = "id")
	private Employee employee;

	@OneToOne(targetEntity = Employer.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "employerid", referencedColumnName = "id")
	private Employer employer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

}
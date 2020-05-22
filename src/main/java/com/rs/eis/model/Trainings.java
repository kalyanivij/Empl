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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity
@Table(name="trainings")
@EntityListeners(AuditingEntityListener.class)
public class Trainings {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String courseType;
	private String duration;
	private String startDate;
	private String endDate;
	private String byWhom;
	private Date created;
	private Date updated;
	private int employeeId;
	private int employerId;

	public Trainings() {
	}

	
	public Trainings(int id, String courseType, String duration, String startDate, String endDate, String byWhom,
			Date created, Date updated, int employeeId, int employerId) {
		super();
		this.id = id;
		this.courseType = courseType;
		this.duration = duration;
		this.startDate = startDate;
		this.endDate = endDate;
		this.byWhom = byWhom;
		this.created = created;
		this.updated = updated;
		this.employeeId = employeeId;
		this.employerId = employerId;
	}


	/*@OneToOne(targetEntity=Employee.class,cascade=CascadeType.ALL)
	@JoinColumn(name="employeeid",referencedColumnName="id")
	private Employee employee;
	
	@OneToOne(targetEntity=Employer.class,cascade=CascadeType.ALL)
	@JoinColumn(name="employerid",referencedColumnName="id")
	private Employer employer;*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
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

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getByWhom() {
		return byWhom;
	}

	public void setByWhom(String byWhom) {
		this.byWhom = byWhom;
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

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeid(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployerId() {
		return employerId;
	}

	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}

	

	
	
}

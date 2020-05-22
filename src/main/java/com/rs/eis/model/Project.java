package com.rs.eis.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity
@Table(name="project")
@EntityListeners(AuditingEntityListener.class)
public class Project {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String startDate;
	private String endDate;
	private String clientId;
	private String circleId;
	private String departmentId;
	private String technologyId;
	private Date created;
	private Date updated;

	public Project() {
	}
	public Project(int id, String name, String startDate, String endDate, String clientId, String circleId,
			String departmentId, String technologyId) {
		
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.clientId = clientId;
		this.circleId = circleId;
		this.departmentId = departmentId;
		this.technologyId = technologyId;
		//this.allocation = allocation;
	}
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@PrimaryKeyJoinColumn
	//private Allocation allocation;

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
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getCircleId() {
		return circleId;
	}
	public void setCircleId(String circleId) {
		this.circleId = circleId;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getTechnologyId() {
		return technologyId;
	}
	public void setTechnologyId(String technologyId) {
		this.technologyId = technologyId;
	}
//	public Allocation getAllocation() {
//		return allocation;
//	}
//	public void setAllocation(Allocation allocation) {
//		this.allocation = allocation;
//	}
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

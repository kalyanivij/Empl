package com.rs.eis.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="allocation")
@EntityListeners(AuditingEntityListener.class)
public class Allocation {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int projectid;// One To Many Key
	
	public Allocation() {
		
	}

	public Allocation(int id, String name) {
		
		this.id = id;
		this.name = name;
		
	}
//	@OneToMany(targetEntity=Allocation.class,cascade=CascadeType.ALL)
//	@JoinColumn(name="projectid",referencedColumnName="id")
//	private Project project;

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

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

//	public Project getProject() {
//		return project;
//	}
//
//	public void setProject(Project project) {
//		this.project = project;
//	}
	
	
	
	
	
	
}

package com.rs.eis.model;

<<<<<<< HEAD
=======
import java.util.Date;

>>>>>>> branch 'master' of git@github.com:kalyanivij/Empl.git
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of git@github.com:kalyanivij/Empl.git
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
	private int projectid;
	private Date created;
	private Date updated;

	
	public Allocation() {
		
	}

	public Allocation(int id, String name) {
		
		this.id = id;
		this.name = name;
		
	}


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
	
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}


	
}

package com.rs.eis.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Book")
@EntityListeners(AuditingEntityListener.class)
public class Book{
	
	/*
	 * private static final long serialVersionUID = 1L;
	 */	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	//private int refBookNumber;

	
	  @ManyToOne(cascade = CascadeType.ALL)
	  
	  @PrimaryKeyJoinColumn 
	 	private Library library;

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
	/*
	 * public void setRefBookNumber(int refBookNumber) { this.refBookNumber =
	 * refBookNumber; } public int getRefBookNumber() { return refBookNumber; }
	 */

	public void setCreated(Date currentDate) {

	}

}

package com.rs.eis.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;





@Entity
@Table(name = "Beneficiary")
public class Beneficiary {

	@Id
	@Column(updatable = false, nullable = false)
	@GeneratedValue
	private int id;
	@Column
	private String firstname;
	@Column
	private String middlename;
	@Column
	private String lastname;
	@Column
	private String state;
	@Column
	private String country;
	@Column
	private String postal;
	@Column
	private String created;
	@Column
	private String updated;
	
	public Beneficiary(int id, String firstname, String middlename, String lastname, String state, String country, String postal,
			int userId,String percentage) {
		
		this.id = id;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.state = state;
		this.country = country;
		this.postal = postal;
		this.percentage= percentage;
		
		//this.userId = userId;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	@Column
	private String percentage;


	public Beneficiary() {
		
	}

	
	/*
	 * @OneToOne(targetEntity=User.class,cascade=CascadeType.ALL)
	 * 
	 * @JoinColumn(name="empid",referencedColumnName="id") private Employee
	 * employee;
	 */

	
	

	

	/*public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}*/

}

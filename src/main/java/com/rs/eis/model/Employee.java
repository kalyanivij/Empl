package com.rs.eis.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name="Employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dateOfBirth;
	private String bloodGroup;
	private String gender;
	private String maritalStatus;
	private String differentlyAbled;
	private String aadharNo;
	private String panNo;
	private String passportNo;
	private Date created;
	private Date updated;

	public Employee() {
	}
	public Employee(int id, String firstName, String middleName, String lastName, String dateOfBirth, String bloodGroup,
			String gender, String maritalStatus, String differentlyAbled, String aadharNo, String panNo,String passportNo , Address address) {
		
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.bloodGroup = bloodGroup;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.aadharNo= aadharNo;
		this.differentlyAbled= differentlyAbled;
		this.panNo= panNo;
		this.passportNo= passportNo;

	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Employer employer;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Trainings trainings;
	
	/*
	 * @OneToMany(cascade=CascadeType.ALL)
	 * 
	 * @PrimaryKeyJoinColumn private List<Address> address;
	 * 
	 * @OneToMany(cascade=CascadeType.ALL)
	 * 
	 * @PrimaryKeyJoinColumn private List<Education> education;
	 * 
	 * @OneToMany(cascade=CascadeType.ALL)
	 * 
	 * @PrimaryKeyJoinColumn private List<Contact> contact;
	 * 
	 * @OneToMany(cascade=CascadeType.ALL)
	 * 
	 * @PrimaryKeyJoinColumn private List<Circle> circle;
	 */
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getDifferentlyAbled() {
		return differentlyAbled;
	}
	public void setDifferentlyAbled(String differentlyAbled) {
		this.differentlyAbled = differentlyAbled;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
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
	public Trainings getTrainings() {
		return trainings;
	}
	public void setTrainings(Trainings trainings) {
		this.trainings = trainings;
	}
	
	/*
	 * public List<Address> getAddress() { return address; } public void
	 * setAddress(List<Address> address) { this.address = address; }
	 */
	
}

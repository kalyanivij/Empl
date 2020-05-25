package com.rs.eis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Suffix")
public class Suffix {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	private String code;
	private String value;
	private Date created;
	private Date updated;

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}

	public Suffix() {

	}

	public Suffix(int id, String code, String value) {

		this.id = id;
		this.code = code;
		this.value = value;

	}

	public int getId() {
		return id;
	} 

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setCreated(Date currentDate) {
		// TODO Auto-generated method stub

	}

	public void setUpdated(Date currentDate) {
		// TODO Auto-generated method stub
		
	}
}

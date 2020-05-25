package com.rs.eis.model;

import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="empassets")
@EntityListeners(AuditingEntityListener.class)
public class EmpAssets {
	@Id    
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private static int id;     
	private String assetsid;
	private String employeeid;
	private String date;

	public EmpAssets() {

	}                                           

	public EmpAssets(int id, String assetsid, String employeeid, String date) {
		this.id = id;
		this.assetsid = assetsid;
		this.employeeid = employeeid;
		this.date = date;

	}
                                   
	@OneToOne(cascade = CascadeType.ALL)
	public static int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssetsid() {
		return assetsid;
	}

	public void setAssetsid(String assetsid) {
		this.assetsid = assetsid;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "EmpAssets[id=" + id + ",assetsid=" + assetsid + ",employeeid=" + employeeid + ",date=" + date + "]";
	}

}

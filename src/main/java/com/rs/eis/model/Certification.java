package com.rs.eis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "certifications")
@EntityListeners(AuditingEntityListener.class)
public class Certification {
	@Id
	@Column(name = "certificationId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int certificationId;

	private String type;
	private String acknowledgement;
	private int employeeId;
	private int employerId;

	public Certification() {
	}

	public Certification(String type, String acknowLedgement, int employeeId, int employerId, int certificationId) {

		this.type = type;
		this.acknowledgement = acknowLedgement;
		this.employeeId = employeeId;
		this.employerId = employerId;
		this.certificationId = certificationId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAcknowledgement() {
		return acknowledgement;
	}

	public void setAcknowledgement(String acknowledgement) {
		this.acknowledgement = acknowledgement;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployerId() {
		return employerId;
	}

	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}

	public int getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}

	@Override
	public String toString() {
		return "certifications [type=" + type + ", acknowledgement=" + acknowledgement + ", employeeId=" + employeeId
				+ ", employerId=" + employerId + "]";
	}
}

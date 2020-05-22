package com.rs.eis.request;

import javax.validation.constraints.NotEmpty;

public class DonationVO {

	private int id;

	@NotEmpty(message = "please enter code")
	private String code;
	
	@NotEmpty(message = "please enter value")
	private String value;

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

}

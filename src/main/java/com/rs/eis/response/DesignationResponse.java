package com.rs.eis.response;

import com.rs.eis.model.Designation;

public class DesignationResponse extends AbstractResponse {

	private Designation designation;

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

}

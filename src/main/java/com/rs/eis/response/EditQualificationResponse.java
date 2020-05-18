package com.rs.eis.response;

import com.rs.eis.model.Qualification;

public class EditQualificationResponse extends AbstractResponse {

	private Qualification qualification;

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

}

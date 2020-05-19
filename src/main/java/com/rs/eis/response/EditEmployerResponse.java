package com.rs.eis.response;

import com.rs.eis.model.Employer;

public class EditEmployerResponse extends AbstractResponse {

	private Employer employer;

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

}

package com.rs.eis.response;

import com.rs.eis.model.Visa;

public class DeleteVisaResponse extends AbstractResponse {
	private Visa visa;

	public Visa getVisa() {
		return visa;
	}

	public void setVisa(Visa visa) {
		this.visa = visa;
	}

}

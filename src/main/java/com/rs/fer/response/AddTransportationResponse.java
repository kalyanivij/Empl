package com.rs.fer.response;

import com.rs.fer.model.Transportation;

public class AddTransportationResponse extends AbstractResponse {

	private Transportation transportation;

	public Transportation getTransportation() {
		return transportation;
	}

	public void setTransportation(Transportation transportation) {
		this.transportation = transportation;
	}

}

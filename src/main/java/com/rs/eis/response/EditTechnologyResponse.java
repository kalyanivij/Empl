package com.rs.eis.response;

import com.rs.eis.model.Technology;

public class EditTechnologyResponse extends AbstractResponse {
	
	private Technology technology;
	
	public Technology getTechnology() {
		return technology;
	}
	public void setTechnology(Technology technology) {
		this.technology = technology;
	}
	
}

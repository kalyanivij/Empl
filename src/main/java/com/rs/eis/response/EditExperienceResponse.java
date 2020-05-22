package com.rs.eis.response;

import com.rs.eis.model.Experience;

public class EditExperienceResponse extends AbstractResponse {

	private Experience experience;

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

}

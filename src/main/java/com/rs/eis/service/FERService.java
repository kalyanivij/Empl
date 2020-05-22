package com.rs.eis.service;

import com.rs.eis.model.Experience;
import com.rs.eis.model.Technology;
import com.rs.eis.response.AddExperienceResponse;
import com.rs.eis.response.AddTechnologyResponse;
import com.rs.eis.response.DeleteTechnologyResponse;
import com.rs.eis.response.EditExperienceResponse;
import com.rs.eis.response.EditTechnologyResponse;
import com.rs.eis.response.GetExperienceResponse;
import com.rs.eis.response.GetTechnologyResponse;

public interface FERService {
	

	GetExperienceResponse getexperience(int employeeid);

	AddExperienceResponse addexperience(Experience experience);

	EditExperienceResponse editexperience(Experience experience);

	GetTechnologyResponse gettechnology(int id);

	DeleteTechnologyResponse deletetechnology(int id);

	AddTechnologyResponse addtechnology(Technology technology);

	EditTechnologyResponse edittechnology(Technology technology);

}

package com.rs.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.eis.model.Experience;
import com.rs.eis.model.Technology;
import com.rs.eis.repository.ExperienceRepository;
import com.rs.eis.repository.TechnologyRepository;
import com.rs.eis.response.AddExperienceResponse;
import com.rs.eis.response.AddTechnologyResponse;
import com.rs.eis.response.DeleteTechnologyResponse;
import com.rs.eis.response.EditExperienceResponse;
import com.rs.eis.response.EditTechnologyResponse;
import com.rs.eis.response.GetExperienceResponse;
import com.rs.eis.response.GetTechnologyResponse;
import com.rs.eis.service.FERService;
import com.rs.eis.util.DateUtil;

@Service
public class FERServiceImpl implements FERService {

	@Autowired
	ExperienceRepository experienceRepository;
	@Autowired
	TechnologyRepository technologyRepository;

	
	@Override
	public GetExperienceResponse getexperience(int employeeid) {

		GetExperienceResponse response = new GetExperienceResponse();
		Optional<Experience> expObj = experienceRepository.findById(employeeid);

		if (expObj.isPresent()) {
			response.setExperience(expObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Not valid...");
		}

		return response;

	}

	@Override
	public GetTechnologyResponse gettechnology(int id) {
		GetTechnologyResponse response = new GetTechnologyResponse();
		Optional<Technology> techObj = technologyRepository.findById(id);
		if (techObj.isPresent()) {
			response.setTechnology(techObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No technology available on that id...");
		}

		return response;

	}

	
	  @Override
	  
	  public AddTechnologyResponse addtechnology(Technology technology) {
	  AddTechnologyResponse response = new AddTechnologyResponse();
	  
	  Optional<Technology> techObj = technologyRepository.findById(technology.getId());
	  

		if (techObj.isPresent()) {

			technology.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			technology = technologyRepository.save(technology);

			response.setTechnology(technology);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as transportationId is not present in transportation table");
		}

		return response;
	  }

	@Override public DeleteTechnologyResponse deletetechnology(int id) {
		DeleteTechnologyResponse response = new DeleteTechnologyResponse();

		Optional<Technology> tecObj = technologyRepository.findById(id);

		if (tecObj.isPresent()) {
			Technology technology = tecObj.get();
			technologyRepository.delete(technology);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as expenseId is not present in expense table");
		}

		return response;
}

	@Override
	public EditTechnologyResponse edittechnology(Technology technology) {
		EditTechnologyResponse response = new EditTechnologyResponse();

		Optional<Technology> tcObj = technologyRepository.findById(technology.getId());

		if (tcObj.isPresent()) {

			technology.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			technology = technologyRepository.save(technology);

			response.setTechnology(technology);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in technology table...");
		}

		return response;
	}

	@Override
	public AddExperienceResponse addexperience(Experience experience) {
		 AddExperienceResponse response = new AddExperienceResponse();
		  
		  Optional<Experience> exObj = experienceRepository.findById(experience.getId());
		  

			if (exObj.isPresent()) {

				experience.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
				experience = experienceRepository.save(experience);

				response.setExperience(experience);
				response.setStatusCode("000");
				response.setStatus(HttpStatus.OK);
			} else {
				response.setStatusCode("001");
				response.setStatus(HttpStatus.PRECONDITION_FAILED);
				response.setErrorMessage("Invalid input...");
			}

			return response;
	}

	@Override
	public EditExperienceResponse editexperience(Experience experience) {
		EditExperienceResponse response = new EditExperienceResponse();

		Optional<Experience> expeObj = experienceRepository.findById(experience.getId());

		if (expeObj.isPresent()) {

			experience.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			experience = experienceRepository.save(experience);

			response.setExperience(experience);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in experience table...");
		}

		return response;
	}
}
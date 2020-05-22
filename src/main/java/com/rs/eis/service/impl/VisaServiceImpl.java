package com.rs.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.eis.model.Visa;
import com.rs.eis.repository.VisaRepository;
import com.rs.eis.response.AddVisaResponse;
import com.rs.eis.response.DeleteVisaResponse;
import com.rs.eis.response.EditVisaResponse;
import com.rs.eis.service.VisaService;

@Service
public class VisaServiceImpl implements VisaService {
	@Autowired
	VisaRepository visaRepository;

	@Override
	public AddVisaResponse addVisa(Visa visa) {

		AddVisaResponse response = new AddVisaResponse();

		visa = visaRepository.save(visa);

		response.setVisa(visa);

		response.setStatusCode("000");

		response.setStatus(HttpStatus.OK);
		return response;
	}

	public EditVisaResponse editVisa(Visa visa) {
		EditVisaResponse response = new EditVisaResponse();

		Optional<Visa> visaObj = visaRepository.findById(visa.getId());

		if (visaObj.isPresent()) {

			visa = visaRepository.save(visa);

			response.setVisa(visa);

			response.setStatusCode("000");

			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as visa are  not present in visa table");
		}

		return response;

	}

	public DeleteVisaResponse deleteVisa(int id) {
		DeleteVisaResponse response = new DeleteVisaResponse();

		Optional<Visa> visaObj = visaRepository.findById(id);

		if (visaObj.isPresent()) {
			Visa Visa = visaObj.get();

			visaRepository.delete(Visa);

			response.setStatusCode("000");

			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as visa are  not present in visa table");
		}

		return response;

	}

}
package com.rs.fer.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.model.Pf;
import com.rs.fer.model.Transportation;
import com.rs.fer.repository.PfRepository;
import com.rs.fer.repository.TransportationRepository;
import com.rs.fer.response.AddPfResponse;
import com.rs.fer.response.AddTransportationResponse;
import com.rs.fer.response.DeletePfResponse;
import com.rs.fer.response.DeleteTransportationResponse;
import com.rs.fer.response.GetPfResponse;
import com.rs.fer.response.GetTransportationResponse;
import com.rs.fer.service.FERService;
import com.rs.fer.validation.ValidationUtil;

@RestController
@RequestMapping("/api")
public class FERController {
	@Autowired
	FERService ferService;

	@Autowired
	ValidationUtil validationUtil;

	@Autowired
	TransportationRepository transportationRepository;

	@Autowired
	PfRepository pfRepository;

	
	@PostMapping("/transportation")
	public AddTransportationResponse addtransportation(@Valid @RequestBody Transportation transportation) {
		return ferService.addTransportationResponse(transportation);
	}

	@GetMapping("/transportation/{id}")
	public GetTransportationResponse getTransportationById(@PathVariable("id") int id) {
		Set<String> errorMessages = validationUtil.validateGetTransportationRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetTransportationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.getTransportationById(id);
		}

	}

	@DeleteMapping("/transportation/{Id}")
	public DeleteTransportationResponse deleteTransportationById(@PathVariable(value = "id") int id) {
		Set<String> errorMessages = validationUtil.validateDeleteExpenseRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteTransportationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.DeleteTransportation(id);
		}
	}

	@PostMapping("/pf")
	public AddPfResponse addPf(@Valid @RequestBody Pf pf) {
		return ferService.addPfResponse(pf);
	}

	@GetMapping("/pf/{id}")
	public GetPfResponse getPfById(@PathVariable("id") int id) {
		Set<String> errorMessages = validationUtil.validateGetPfRequest(id);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetPfResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.getpfById(id);
		}

	}

	@DeleteMapping("/pf/{id}")
	public DeletePfResponse deletePfById(@PathVariable(value = "id") int id) {
		Set<String> errorMessages = validationUtil.validateDeleteExpenseRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeletePfResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return ferService.DeletePf(id);
		}
	}

}

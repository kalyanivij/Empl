package com.rs.eis.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.eis.model.Trainings;
import com.rs.eis.repository.EmployeeRepository;
import com.rs.eis.repository.EmployerRepository;
import com.rs.eis.repository.TrainingsEmployeeRepository;
import com.rs.eis.repository.TrainingsEmployerRepository;
import com.rs.eis.response.AddEmployeeTrainingsResponse;
import com.rs.eis.response.AddEmployerTrainingsResponse;
import com.rs.eis.response.DeleteTrainingsResponse;
import com.rs.eis.response.EditTrainingsResponse;
import com.rs.eis.response.GetTrainingResponse;
import com.rs.eis.response.GetTrainingsResponse;
import com.rs.eis.service.EISService;
import com.rs.eis.validation.ValidationUtil;


@RestController
@RequestMapping("/empl")
public class EISController {
	
	@Autowired
	EISService eisService;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployerRepository employerRepository;
	
	@Autowired
	ValidationUtil validationUtil;

	@Autowired
	TrainingsEmployeeRepository trainigempRepository;
	@Autowired
	TrainingsEmployerRepository trainigemprRepository;

	
	
	private int trainingId;
	
	@PostMapping("/training")
	public AddEmployeeTrainingsResponse saveTrainingEmployee(@Valid @RequestBody Trainings trainings) {
		return eisService.saveTrainingEmployee(trainings);
	}
	@PostMapping("/trainings")
	public AddEmployerTrainingsResponse saveTrainingEmployer(@Valid @RequestBody Trainings trainings) {
		return eisService.saveTrainingEmployer(trainings);
	}
	
	@PutMapping("/trainings/{id}")
	public EditTrainingsResponse editTrainings(@PathVariable("id") int Id, @Valid @RequestBody Trainings trainings) {
		return eisService.editTraining(trainings);
	}
	@DeleteMapping("/trainings/{trainingId}")
	public DeleteTrainingsResponse deleteTrainings(@PathVariable(value = "trainingId") int trainingId) {
		Set<String> errorMessages = validationUtil.validateDeleteTrainingsRequest(trainingId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteTrainingsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.deleteTraining(trainingId);
		}
	}
	@GetMapping("/trainings/{id}")
	public GetTrainingResponse getTrainingsById(@PathVariable("id") int trainingId) {
		Set<String> errorMessages = validationUtil.validateGetTrainingRequest(trainingId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetTrainingResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.getTrainingsById(trainingId);
		}
	}
	@GetMapping("/trainingemp/{employeeId}")
	public GetTrainingsResponse getTrainings(@PathVariable("employeeId") int employeeId) {
		Set<String> errorMessages = validationUtil.validateGetTrainingsRequest(employeeId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetTrainingsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.getTrainings(employeeId);
		}
	}
	@GetMapping("/trainingemployer/{employerId}")
	public GetTrainingsResponse getTraining(@PathVariable("employerId") int employerId) {
		Set<String> errorMessages = validationUtil.validateGetTrainingsRequest(employerId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetTrainingsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.getTraining(employerId);
		}
	}


	
}

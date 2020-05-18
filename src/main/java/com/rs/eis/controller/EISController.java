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

import com.rs.eis.model.Contact;
import com.rs.eis.model.Trainings;
import com.rs.eis.repository.ContactRepository;
import com.rs.eis.repository.EmployeeRepository;
import com.rs.eis.repository.EmployerRepository;
import com.rs.eis.repository.TrainingsRepository;
import com.rs.eis.response.ContactResponse;
import com.rs.eis.response.DeleteContactResponse;
import com.rs.eis.response.DeleteTrainingsResponse;
import com.rs.eis.response.EditContactResponse;
import com.rs.eis.response.EditTrainingsResponse;
import com.rs.eis.response.GetContactResponse;
import com.rs.eis.response.GetContactsResponse;
import com.rs.eis.response.GetTrainingResponse;
import com.rs.eis.response.GetTrainingsResponse;
import com.rs.eis.response.TrainingsResponse;
import com.rs.eis.service.EISService;
import com.rs.eis.validation.ValidationUtil;

@RestController
@RequestMapping("/eis")
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
	TrainingsRepository trainigsRepository;

	@Autowired
	ContactRepository contactRepository;

	private int trainingId;

	@PostMapping("/training")
	public TrainingsResponse saveTraining(@Valid @RequestBody Trainings trainings) {
		return eisService.saveTraining(trainings);
	}

	@PostMapping("/trainings")
	public TrainingsResponse saveTrainings(@Valid @RequestBody Trainings trainings) {
		return eisService.saveTrainings(trainings);
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

	@GetMapping("/training/{employeeId}")
	public GetTrainingsResponse getTrainings(@PathVariable("employeeId") int employeeid) {
		Set<String> errorMessages = validationUtil.validateGetTrainingsRequest(employeeid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetTrainingsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.getTrainings(employeeid);
		}
	}

	@GetMapping("/trainingemployer/{employerId}")
	public GetTrainingsResponse getTraining(@PathVariable("employerId") int employerid) {
		Set<String> errorMessages = validationUtil.validateGetTrainingsRequest(employerid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetTrainingsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.getTraining(employerid);
		}
	}

	@PostMapping("/contact")
	public ContactResponse saveContact(@Valid @RequestBody Contact contact) {
		return eisService.saveContact(contact);
	}

	@PostMapping("/contacts")
	public ContactResponse saveContacts(@Valid @RequestBody Contact contact) {
		return eisService.saveContacts(contact);
	}

	@PutMapping("/contact/{id}")
	public EditContactResponse editContact(@PathVariable("id") int Id, @Valid @RequestBody Contact contact) {
		return eisService.editContact(contact);
	}

	@DeleteMapping("/contact/{contactId}")
	public DeleteContactResponse deleteContact(@PathVariable(value = "contactId") int contactId) {
		Set<String> errorMessages = validationUtil.validateDeleteContactRequest(contactId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteContactResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.deleteContact(contactId);
		}
	}

	@GetMapping("/contact/{id}")
	public GetContactResponse getContactById(@PathVariable("id") int contactId) {
		Set<String> errorMessages = validationUtil.validateGetContactRequest(contactId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetContactResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.getContactById(contactId);
		}
	}

	@GetMapping("/contact/{employeeId}")
	public GetContactsResponse getContact(@PathVariable("employeeId") int employeeid) {
		Set<String> errorMessages = validationUtil.validateGetContactsRequest(employeeid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetContactsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.getContact(employeeid);
		}
	}

	@GetMapping("/contacts/{employerId}")
	public GetContactsResponse getContacts(@PathVariable("employerId") int employerid) {
		Set<String> errorMessages = validationUtil.validateGetContactsRequest(employerid);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetContactsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.getContacts(employerid);
		}
	}

}

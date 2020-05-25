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
import com.rs.eis.repository.ContactEmployeeRepository;
import com.rs.eis.repository.ContactEmployerRepository;
import com.rs.eis.repository.EmployeeRepository;
import com.rs.eis.repository.EmployerRepository;
import com.rs.eis.request.ContactVO;
import com.rs.eis.response.AddEmployeeContactResponse;
import com.rs.eis.response.AddEmployerContactResponse;
import com.rs.eis.response.DeleteContactResponse;
import com.rs.eis.response.EditContactResponse;
import com.rs.eis.response.GetContactResponse;
import com.rs.eis.response.GetContactsResponse;
import com.rs.eis.service.ContactService;
import com.rs.eis.validation.ContactValidationUtil;

@RestController
@RequestMapping("/eis")
public class ContactController {

	@Autowired
	ContactService contactService;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployerRepository employerRepository;

	@Autowired
	ContactValidationUtil validationUtil;

	@Autowired
	ContactEmployeeRepository contactempRepository;

	@Autowired
	ContactEmployerRepository contactemprRepository;

	@PostMapping("/contact")
	public AddEmployeeContactResponse saveContactEmployee(@RequestBody ContactVO contactVO) {
		return contactService.saveContactEmployee(contactVO);
	}

	@PostMapping("/contacts")
	public AddEmployerContactResponse saveContactEmployer(@RequestBody ContactVO contactVO) {
		return contactService.saveContactEmployer(contactVO);
	}

	@PutMapping("/contact/{id}")
	public EditContactResponse editContact(@PathVariable("id") int Id, @Valid @RequestBody Contact contact) {
		return contactService.editContact(contact);
	}

	@DeleteMapping("/contact/{contactId}")
	public DeleteContactResponse deleteContact(@PathVariable(value = "contactId") int contactId) {
		Set<String> errorMessages = validationUtil.validateDeleteContactRequest(contactId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteContactResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return contactService.deleteContact(contactId);
		}
	}

	@GetMapping("/contact/{id}")
	public GetContactResponse getContactById(@PathVariable("id") int contactId) {
		Set<String> errorMessages = validationUtil.validateGetContactRequest(contactId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetContactResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return contactService.getContactById(contactId);
		}
	}

	@GetMapping("/contactemp/{employeeId}")
	public GetContactsResponse getContact(@PathVariable("employeeId") int employeeId) {
		Set<String> errorMessages = validationUtil.validateGetContactsRequest(employeeId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetContactsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return contactService.getContact(employeeId);
		}
	}

	@GetMapping("/contactemployer/{employerId}")
	public GetContactsResponse getTrainings(@PathVariable("employerId") int employerId) {
		Set<String> errorMessages = validationUtil.validateGetContactsRequest(employerId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetContactsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return contactService.getContacts(employerId);
		}
	}

}

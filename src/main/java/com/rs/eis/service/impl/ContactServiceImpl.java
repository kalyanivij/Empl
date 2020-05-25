package com.rs.eis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.eis.model.Contact;
import com.rs.eis.model.Employee;
import com.rs.eis.model.Employer;
import com.rs.eis.repository.ContactEmployeeRepository;
import com.rs.eis.repository.ContactEmployerRepository;
import com.rs.eis.repository.ContactRepository;
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
import com.rs.eis.util.ContactUtil;
import com.rs.eis.util.DateUtil;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployerRepository employerRepository;

	@Autowired
	ContactRepository contactRepository;

	@Autowired
	ContactEmployeeRepository contactempRepository;

	@Autowired
	ContactEmployerRepository contactemprRepository;

	@Override
	public AddEmployeeContactResponse saveContactEmployee(ContactVO contactVO) {
		AddEmployeeContactResponse response = new AddEmployeeContactResponse();
		Optional<Employee> emp = employeeRepository.findById(contactVO.getEmployeeId());
		if (emp.isPresent()) {
			Contact contact = ContactUtil.loadContactVOToContact(contactVO);
			contact.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			contact = contactRepository.save(contact);

			response.setContact(contact);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in the table");
		}

		return response;
	}

	@Override
	public AddEmployerContactResponse saveContactEmployer(ContactVO contactVO) {
		AddEmployerContactResponse response = new AddEmployerContactResponse();
		Optional<Employer> empr = employerRepository.findById(contactVO.getEmployerId());
		if (empr.isPresent()) {
			Contact contact = ContactUtil.loadContactVOToContact(contactVO);
			contact.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			contact = contactRepository.save(contact);

			response.setContact(contact);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in the table");
		}

		return response;
	}

	@Override
	public EditContactResponse editContact(Contact contact) {
		EditContactResponse response = new EditContactResponse();

		Optional<Contact> contactObj = contactRepository.findById(contact.getId());

		if (contactObj.isPresent()) {

			contact.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			contact = contactRepository.save(contact);

			response.setContact(contact);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as contactId is not present in contact table");
		}

		return response;
	}

	@Override
	public DeleteContactResponse deleteContact(int contactId) {
		DeleteContactResponse response = new DeleteContactResponse();

		Optional<Contact> contact = contactRepository.findById(contactId);

		if (contact.isPresent()) {
			Contact contactObj = contact.get();
			contactRepository.delete(contactObj);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as contactId is not present in contact table");
		}

		return response;
	}

	@Override
	public GetContactResponse getContactById(int contactId) {
		GetContactResponse response = new GetContactResponse();
		Optional<Contact> contact = contactRepository.findById(contactId);
		if (contact.isPresent()) {
			response.setContact(contact.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No Contact Found for the given contactid");
		}

		return response;
	}

	@Override
	public GetContactsResponse getContact(int employeeId) {
		GetContactsResponse response = new GetContactsResponse();
		List<Contact> contact = contactempRepository.findByEmployeeId(employeeId);
		if (!contact.isEmpty()) {
			response.setContact(contact);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in contact table");
		}

		return response;
	}

	@Override
	public GetContactsResponse getContacts(int employerId) {
		GetContactsResponse response = new GetContactsResponse();
		List<Contact> contact = contactemprRepository.findByEmployerId(employerId);
		if (!contact.isEmpty()) {
			response.setContact(contact);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in contact table");
		}

		return response;
	}

}

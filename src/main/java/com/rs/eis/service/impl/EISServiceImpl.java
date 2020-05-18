package com.rs.eis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.eis.model.Contact;
import com.rs.eis.model.Emp_awards;
import com.rs.eis.model.Employee;
import com.rs.eis.model.Employer;
import com.rs.eis.model.Trainings;
import com.rs.eis.repository.ContactRepository;
import com.rs.eis.repository.EmployeeRepository;
import com.rs.eis.repository.EmployerRepository;
import com.rs.eis.repository.TrainingsRepository;
import com.rs.eis.response.AddEmp_awardsResponse;
import com.rs.eis.response.ContactResponse;
import com.rs.eis.response.DeleteContactResponse;
import com.rs.eis.response.DeleteEmp_awardsResponse;
import com.rs.eis.response.DeleteTrainingsResponse;
import com.rs.eis.response.EditContactResponse;
import com.rs.eis.response.EditTrainingsResponse;
import com.rs.eis.response.GetContactResponse;
import com.rs.eis.response.GetContactsResponse;
import com.rs.eis.response.GetEmp_awardsResponse;
import com.rs.eis.response.GetTrainingResponse;
import com.rs.eis.response.GetTrainingsResponse;
import com.rs.eis.response.TrainingsResponse;
import com.rs.eis.service.EISService;
import com.rs.eis.util.DateUtil;

@Service
public class EISServiceImpl implements EISService {

	@Autowired
	EISService eisService;
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployerRepository employerRepository;

	@Autowired
	TrainingsRepository trainingsRepository;

	@Autowired
	ContactRepository contactRepository;

	@Override
	public TrainingsResponse saveTraining(Trainings trainings) {
		TrainingsResponse response = new TrainingsResponse();
		Optional<Employee> emp = employeeRepository.findById(trainings.getEmployee().getId());
		if (emp.isPresent()) {

			trainings.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			trainings = trainingsRepository.save(trainings);

			response.setTrainings(trainings);

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
	public TrainingsResponse saveTrainings(Trainings trainings) {
		TrainingsResponse response = new TrainingsResponse();
		Optional<Employer> empr = employerRepository.findById(trainings.getEmployer().getId());
		if (empr.isPresent()) {

			trainings.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			trainings = trainingsRepository.save(trainings);

			response.setTrainings(trainings);

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
	public EditTrainingsResponse editTraining(Trainings trainings) {
		EditTrainingsResponse response = new EditTrainingsResponse();

		Optional<Trainings> trainingsObj = trainingsRepository.findById(trainings.getId());

		if (trainingsObj.isPresent()) {

			trainings.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			trainings = trainingsRepository.save(trainings);

			response.setTrainings(trainings);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as trainingId is not present in trainings table");
		}

		return response;
	}

	@Override
	public DeleteTrainingsResponse deleteTraining(int trainingId) {
		DeleteTrainingsResponse response = new DeleteTrainingsResponse();

		Optional<Trainings> trainings = trainingsRepository.findById(trainingId);

		if (trainings.isPresent()) {
			Trainings training = trainings.get();
			trainingsRepository.delete(training);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as trainingId is not present in trainings table");
		}

		return response;
	}

	@Override
	public GetTrainingResponse getTrainingsById(int trainingId) {
		GetTrainingResponse response = new GetTrainingResponse();
		Optional<Trainings> trainings = trainingsRepository.findById(trainingId);
		if (trainings.isPresent()) {
			response.setTrainings(trainings.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No Trainings Found for the given trainingid");
		}

		return response;
	}

	@Override
	public GetTrainingsResponse getTrainings(int employeeid) {
		GetTrainingsResponse response = new GetTrainingsResponse();
		List<Trainings> trainings = trainingsRepository.findByEmployee(employeeid);
		if (!trainings.isEmpty()) {
			response.setTrainings(trainings);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in trainings table");
		}

		return response;
	}

	@Override
	public GetTrainingsResponse getTraining(int employerid) {
		GetTrainingsResponse response = new GetTrainingsResponse();
		List<Trainings> trainings = trainingsRepository.findByEmployee(employerid);
		if (!trainings.isEmpty()) {
			response.setTrainings(trainings);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in trainings table");
		}

		return response;
	}

	@Override
	public GetEmp_awardsResponse getEmp_awardsByemployeeid(int employeeid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetEmp_awardsResponse emp_awardsReport(int employeeid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteEmp_awardsResponse deleteEmp_awards(int employeeid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddEmp_awardsResponse addEmp_awards(Emp_awards emp_awards) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContactResponse saveContact(Contact contact) {
		ContactResponse response = new ContactResponse();
		Optional<Employee> emp = employeeRepository.findById(contact.getEmployee().getId());
		if (emp.isPresent()) {

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
	public ContactResponse saveContacts(Contact contact) {
		ContactResponse response = new ContactResponse();
		Optional<Employer> empr = employerRepository.findById(contact.getEmployer().getId());
		if (empr.isPresent()) {

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
			response.setErrorMessage("Invalid Input as ContactId is not present in Contact table");
		}

		return response;
	}

	@Override
	public DeleteContactResponse deleteContact(int contactId) {
		DeleteContactResponse response = new DeleteContactResponse();

		Optional<Contact> contact = contactRepository.findById(contactId);

		if (contact.isPresent()) {
			Contact contacts = contact.get();
			contactRepository.delete(contacts);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as contactId is not present in Contact table");
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
			response.setErrorMessage("No Contacts Found for the given contactid");
		}

		return response;
	}

	@Override
	public GetContactsResponse getContact(int employeeid) {
		GetContactsResponse response = new GetContactsResponse();
		List<Contact> contact = contactRepository.findByEmployee(employeeid);
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
	public GetContactsResponse getContacts(int employerid) {
		GetContactsResponse response = new GetContactsResponse();
		List<Contact> contact = contactRepository.findByEmployee(employerid);
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

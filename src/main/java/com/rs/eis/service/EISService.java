package com.rs.eis.service;

import com.rs.eis.model.Contact;
import com.rs.eis.model.Emp_awards;
import com.rs.eis.model.Trainings;
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

public interface EISService {

	TrainingsResponse saveTraining(Trainings trainings);

	TrainingsResponse saveTrainings(Trainings trainings);

	EditTrainingsResponse editTraining(Trainings trainings);

	DeleteTrainingsResponse deleteTraining(int trainingId);

	GetTrainingResponse getTrainingsById(int trainingId);

	GetTrainingsResponse getTrainings(int employeeid);

	GetTrainingsResponse getTraining(int employerid);

	GetEmp_awardsResponse getEmp_awardsByemployeeid(int employeeid);

	GetEmp_awardsResponse emp_awardsReport(int employeeid);

	DeleteEmp_awardsResponse deleteEmp_awards(int employeeid);

	AddEmp_awardsResponse addEmp_awards(Emp_awards emp_awards);

	ContactResponse saveContact(Contact contact);

	ContactResponse saveContacts(Contact contact);

	EditContactResponse editContact(Contact contact);

	DeleteContactResponse deleteContact(int contactId);

	GetContactResponse getContactById(int contactId);

	GetContactsResponse getContact(int employeeid);

	GetContactsResponse getContacts(int employerid);

}

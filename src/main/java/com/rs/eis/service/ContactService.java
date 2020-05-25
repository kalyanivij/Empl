package com.rs.eis.service;

import com.rs.eis.model.Contact;
import com.rs.eis.request.ContactVO;
import com.rs.eis.response.AddEmployeeContactResponse;
import com.rs.eis.response.AddEmployerContactResponse;
import com.rs.eis.response.DeleteContactResponse;
import com.rs.eis.response.EditContactResponse;
import com.rs.eis.response.GetContactResponse;
import com.rs.eis.response.GetContactsResponse;

public interface ContactService {

	AddEmployeeContactResponse saveContactEmployee(ContactVO contactVO);

	AddEmployerContactResponse saveContactEmployer(ContactVO contactVO);

	EditContactResponse editContact(Contact contact);

	DeleteContactResponse deleteContact(int contactId);

	GetContactResponse getContactById(int contactId);

	GetContactsResponse getContact(int employeeId);

	GetContactsResponse getContacts(int employerId);

}

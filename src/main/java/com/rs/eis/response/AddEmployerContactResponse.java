package com.rs.eis.response;

import com.rs.eis.model.Contact;

public class AddEmployerContactResponse extends AbstractResponse {

	private Contact contact;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}

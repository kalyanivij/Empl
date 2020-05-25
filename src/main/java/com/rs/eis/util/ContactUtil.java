package com.rs.eis.util;

import com.rs.eis.model.Contact;
import com.rs.eis.request.ContactVO;

public class ContactUtil {

	public static Contact loadContactVOToContact(ContactVO contactVO) {
		Contact contact = new Contact();

		contact.setCountryCode(contactVO.getCountryCode());
		contact.setValue(contactVO.getValue());
		contact.setType(contactVO.getType());
		// contact.setEmployeeId(contactVO.getEmployeeId());
		// contact.setEmployerId(contactVO.getEmployerId());

		contact.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));

		return contact;

	}

	public static Contact loadEditContactVOToContact(Contact contact, Contact contactdb) {
		contactdb.setCountryCode(contact.getCountryCode());
		contactdb.setValue(contact.getValue());
		contactdb.setType(contact.getType());
		// contactdb.setEmployeeId(contact.getEmployeeId());
		// contactdb.setEmployerId(contact.getEmployerId());

		contact.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));

		return contact;
	}
}

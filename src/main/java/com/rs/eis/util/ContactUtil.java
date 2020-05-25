package com.rs.eis.util;

import com.rs.eis.model.Contact;
import com.rs.eis.model.Trainings;
import com.rs.eis.request.ContactVO;
import com.rs.eis.request.TrainingsVO;

public class ContactUtil {

	public static Contact loadContactVOToContact(ContactVO contactVO) {
		Contact contact = new Contact();

		contact.setCountryCode(contactVO.getCountryCode());
		contact.setValue(contactVO.getValue());
		contact.setType(contactVO.getType());
		contact.setEmployeeId(contactVO.getEmployeeId());
		contact.setEmployerId(contactVO.getEmployerId());

		contact.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));

		return contact;

	}

}

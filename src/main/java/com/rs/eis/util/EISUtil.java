package com.rs.eis.util;

import com.rs.eis.model.Contact;
import com.rs.eis.request.ContactVO;

public class EISUtil {

	public static Contact loadContactVOToContact(ContactVO contactVO) {
		Contact contact = new Contact();

		contact.setCountryCode(contactVO.getCountryCode());
		contact.setValue(contactVO.getValue());
		contact.setType(contactVO.getType());

		contact.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));

		return contact;

	}

}

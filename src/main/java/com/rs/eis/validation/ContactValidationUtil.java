package com.rs.eis.validation;

import java.util.Set;

import com.rs.eis.request.ContactVO;

public interface ContactValidationUtil {

	Set<String> validateSaveContactEmployeeRequest(ContactVO contactVO);

	Set<String> validateSaveContactEmployerRequest(ContactVO contactVO);

	Set<String> validateDeleteContactRequest(int contactId);

	Set<String> validateGetContactRequest(int employeeId);

	Set<String> validateGetContactsRequest(int employerid);

}

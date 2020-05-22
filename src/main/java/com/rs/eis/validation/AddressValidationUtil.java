package com.rs.eis.validation;

import java.util.Set;

public interface AddressValidationUtil {

	Set<String> validateStateRequest(int id);

	

	Set<String> validateGetStateRequest(int id);

	Set<String> validateDeleteStateRequest(int id);
	

	


}

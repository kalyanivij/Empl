package com.rs.eis.validation;

import java.util.Set;

public interface PrefixValidationUtil {
	
	Set<String> validateGetPrefixRequest(int Id);

	Set<String> validateDeletePrefixRequest(int employeId);
}

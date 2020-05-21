package com.rs.eis.validation;

import java.util.Set;

public interface ValidationUtil {

	Set<String> validateStateRequest(int id);

	Set<String> validateGetStateRequest1(int id);

	Set<String> validateGetStateRequest(int id);

	Set<String> validateDeleteStateRequest(int id);
	

	


}

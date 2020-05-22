package com.rs.eis.validation;

import java.util.Set;

public interface ValidationUtil {

	Set<String> validateDeleteEpm_awardsRequest(int id);

	Set<String> validateGetEmp_awardsRequest(int id);
	
	Set<String> validateGetAllEmp_awardsRequest(int id);


}

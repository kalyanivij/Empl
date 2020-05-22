package com.rs.eis.validation;

import java.util.Set;

public interface ValidationUtil {

		
	Set<String> validatePerfomance_reviewReportRequest(int employeeid);

	Set<String> validateDeletePerfomance_reviewRequest(int employeeid);

	
	
	Set<String> validateGetPerfomance_reviewRequest(int reviewid);
}

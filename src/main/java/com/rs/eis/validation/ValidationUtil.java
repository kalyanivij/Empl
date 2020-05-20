package com.rs.eis.validation;

import java.util.Set;

public interface ValidationUtil {
	
	Set<String> validateEmp_awardsReportRequest(int employeeid);

	Set<String> validateDeleteEpm_awardsRequest(int emp_awardsid);

	Set<String> validateGetEmp_awardsRequest(int emp_awardsid);

	Set<String> validateDeleteTrainingsRequest(int trainingId);

	Set<String> validateGetTrainingRequest(int trainingId);

	Set<String> validateGetTrainingsRequest(int employerid);

	Set<String> validateDeleteContactRequest(int contactId);

	Set<String> validateGetContactRequest(int employeeId);

	Set<String> validateGetContactsRequest(int employerid);

}

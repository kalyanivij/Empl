package com.rs.eis.validation;

import java.util.Set;


import com.rs.eis.request.QualificationVO;

public interface ValidationUtil {

	Set<String> validateQualificationRequest(QualificationVO qualificationVO);

	Set<String> validateGetQualificatuonRequest(int id);

	Set<String> validateDeleteQualificationRequest(int id);
	
	Set<String> validateUpdateQualificationRequest(int id);
	
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

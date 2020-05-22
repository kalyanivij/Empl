package com.rs.eis.validation;

import java.util.Set;

import com.rs.eis.request.CertificationVO;

public interface CertificationValidationUtil {

	Set<String> validateSaveCertificationRequest(CertificationVO certificationVO);

	Set<String> validateDeleteCertificationRequest(int certificationId);

	Set<String> validateGetCertificationRequest(int certificationId);

	Set<String> validateGetCertificationsRequest(int employeeId);

	//Set<String> validateEditCertificationRequest(int certificationId);

}

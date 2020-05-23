package com.rs.eis.validation;

import java.util.Set;

import com.rs.eis.request.ResumeVO;

public interface ResumeValidationUtil {
	
	Set<String> validateAddResumeRequest(ResumeVO resumeVO);

	Set<String> validateDeleteResumeRequest(int resumeId);

	Set<String> validateGetResumeRequest(int employeeId);

}

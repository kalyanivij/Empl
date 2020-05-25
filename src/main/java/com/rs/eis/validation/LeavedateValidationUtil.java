package com.rs.eis.validation;

import java.util.Set;


public interface LeavedateValidationUtil {

	Set<String> validateGetSuffixRequest(int Id);

	Set<String> validateDeleteSuffixRequest(int employeId);
	
	Set<String> validateGetLeave_DataRequest(int Id);

	Set<String> validateDeleteLeave_DataRequest(int employeId);
}
package com.rs.eis.validation;

import java.util.Set;

import com.rs.eis.request.QualificationVO;

public interface ValidationUtil {

	Set<String> validateQualificationRequest(QualificationVO qualificationVO);

	Set<String> validateGetQualificatuonRequest(int id);

	Set<String> validateDeleteQualificationRequest(int id);

}

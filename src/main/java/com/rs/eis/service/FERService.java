package com.rs.eis.service;

import com.rs.eis.model.Qualification;
import com.rs.eis.request.QualificationVO;
import com.rs.eis.response.DeleteQualificationResponse;
import com.rs.eis.response.EditQualificationResponse;
import com.rs.eis.response.GetQualificationResponse;
import com.rs.eis.response.QualificationResponse;

public interface FERService {

	QualificationResponse InsertQualification(QualificationVO qualificationVO);

	GetQualificationResponse getQualififcationById(int id);

	DeleteQualificationResponse deleteQualification(int id);

	EditQualificationResponse editQualification(Qualification qualification);

}

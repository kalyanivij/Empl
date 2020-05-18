package com.rs.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.eis.model.Qualification;
import com.rs.eis.repository.QualificationRepository;
import com.rs.eis.request.QualificationVO;
import com.rs.eis.response.DeleteQualificationResponse;
import com.rs.eis.response.EditQualificationResponse;
import com.rs.eis.response.GetQualificationResponse;
import com.rs.eis.response.QualificationResponse;
import com.rs.eis.service.FERService;
import com.rs.eis.util.FERUtil;

@Service
public class FERServiceImpl implements FERService {

	@Autowired
	QualificationRepository qualificationRepository;

	@Override
	public QualificationResponse InsertQualification(QualificationVO qualificationVO) {

		QualificationResponse qualificationResponse = new QualificationResponse();

		Optional<Qualification> qualificationObj = qualificationRepository.findById(qualificationVO.getId());

		if (!qualificationObj.isPresent()) {

			Qualification qualification = FERUtil.loadQualificationVOToQualification(qualificationVO);

			qualificationResponse.setQualification(qualificationRepository.save(qualification));
			qualificationResponse.setStatusCode("000");
			qualificationResponse.setStatus(HttpStatus.OK);
		} else {
			qualificationResponse.setStatusCode("001");
			qualificationResponse.setStatus(HttpStatus.PRECONDITION_FAILED);
			qualificationResponse
					.setErrorMessage("Invalid Input as QualificationId is not present in Qualification table");
		}
		return qualificationResponse;
	}

	@Override
	public GetQualificationResponse getQualififcationById(int id) {

		GetQualificationResponse response = new GetQualificationResponse();
		Optional<Qualification> QualificationObj = qualificationRepository.findById(id);
		if (QualificationObj.isPresent()) {
			response.setQualification(QualificationObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No Qualification Found for the given qualification id");
		}

		return response;
	}

	@Override
	public DeleteQualificationResponse deleteQualification(int id) {
		DeleteQualificationResponse response = new DeleteQualificationResponse();

		Optional<Qualification> qualificationObj = qualificationRepository.findById(id);

		if (qualificationObj.isPresent()) {
			Qualification qualification = qualificationObj.get();
			qualificationRepository.delete(qualification);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as qualificationId is not present in qualification table");
		}

		return response;

	}

	@Override
	public EditQualificationResponse editQualification(Qualification qualification) {

		EditQualificationResponse response = new EditQualificationResponse();

		Optional<Qualification> qualificationObj = qualificationRepository.findById(qualification.getId());

		if (qualificationObj.isPresent()) {

			qualification = qualificationRepository.save(qualification);

			response.setQualification(qualification);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as qualificationId is not present in qualification table");
		}

		return response;
	}

}

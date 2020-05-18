package com.rs.eis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.eis.model.Certification;
import com.rs.eis.repository.CertificationRepository;
import com.rs.eis.request.CertificationVO;
import com.rs.eis.response.CertificationResponse;
import com.rs.eis.response.DeleteCertificationResponse;
import com.rs.eis.response.EditCertificationResponse;
import com.rs.eis.response.GetCertificationResponse;
import com.rs.eis.response.GetCertificationsResponse;
import com.rs.eis.service.CertificationService;
import com.rs.eis.util.CertificationUtil;
import com.rs.eis.validation.CertificationValidationUtil;

@Service
public class CertificationServiceImpl implements CertificationService {

	@Autowired
	CertificationRepository certificationRepository;

	@Autowired
	CertificationService certificationService;

	@Autowired
	CertificationValidationUtil certificationValidationUtil;

	public CertificationResponse saveCertification(CertificationVO certificationVO) {

		CertificationResponse response = new CertificationResponse();

		Optional<Certification> certObj = certificationRepository
				.findByCertificationId(certificationVO.getCertificationId());
		if (!certObj.isPresent()) {

			Certification certification = CertificationUtil.loadCertificationVOToCertification(certificationVO);

			certification = certificationRepository.save(certification);

			response.setCertification(certification);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as certificationId is  presented in table");
		}

		return response;
	}

	@Override
	public EditCertificationResponse editCertification(Certification certification) {

		EditCertificationResponse response = new EditCertificationResponse();

		Optional<Certification> certObj = certificationRepository
				.findByCertificationId(certification.getCertificationId());
		if (certObj.isPresent()) {
			// Certification certification = new Certification();
			// Certification certification =
			// CertificationUtil.loadCertificationVOToCertification(certificationVO);

			certification = certificationRepository.save(certification);

			response.setCertification(certification);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as certificationId is not presented in table");
		}

		return response;
	}

	@Override
	public DeleteCertificationResponse deleteCertification(int certificationId) {

		DeleteCertificationResponse response = new DeleteCertificationResponse();

		Optional<Certification> certObj = certificationRepository.findByCertificationId(certificationId);

		if (certObj.isPresent()) {

			Certification certification = certObj.get();
			certificationRepository.delete(certification);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as certificationId is not present in table");
		}

		return response;
	}

	@Override
	public GetCertificationResponse getCertification(int certificationId) {
		GetCertificationResponse response = new GetCertificationResponse();

		Optional<Certification> certObj = certificationRepository.findByCertificationId(certificationId);

		if (certObj.isPresent()) {
			response.setCertification(certObj.get());

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as certificationId is not present in table");
		}

		return response;
	}

	@Override
	public GetCertificationsResponse getCertifications(int employeeId) {
		GetCertificationsResponse response = new GetCertificationsResponse();

		List<Certification> certObjs = certificationRepository.findByEmployeeId(employeeId);

		if (!org.springframework.util.CollectionUtils.isEmpty(certObjs)){
			response.setCertifications(certObjs);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as certificationId is not present in table");
		}

		return response;
	}

}
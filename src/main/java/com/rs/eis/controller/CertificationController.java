package com.rs.eis.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.eis.model.Certification;
import com.rs.eis.repository.CertificationRepository;
import com.rs.eis.request.CertificationVO;
import com.rs.eis.response.CertificationResponse;
import com.rs.eis.response.DeleteCertificationResponse;
import com.rs.eis.response.EditCertificationResponse;
import com.rs.eis.response.GetCertificationResponse;
import com.rs.eis.response.GetCertificationsResponse;
import com.rs.eis.service.CertificationService;
import com.rs.eis.validation.CertificationValidationUtil;

@RestController
@RequestMapping("/eis")
public class CertificationController {
	@Autowired
	CertificationService eisService;

	@Autowired
	CertificationValidationUtil certificationValidationUtil;

	@Autowired
	CertificationRepository certificationRepository;

	@PostMapping("/certification")
	public CertificationResponse EmployeeCertifications(@ModelAttribute CertificationVO certificationVO) {

		Set<String> errorMessages = certificationValidationUtil.validateSaveCertificationRequest(certificationVO);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new CertificationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.saveCertification(certificationVO);
		}
	}

	@PutMapping("/certification/{certificationId}")
	public EditCertificationResponse editCertification(@PathVariable("certificationId") int certificationId,
			@ModelAttribute Certification certification) {
		return eisService.editCertification(certification);
	}

	@DeleteMapping("/certification/{certificationId}")
	public DeleteCertificationResponse deleteCertification(
			@PathVariable(value = "certificationId") int certificationId) {
		Set<String> errorMessages = certificationValidationUtil.validateDeleteCertificationRequest(certificationId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteCertificationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.deleteCertification(certificationId);
		}
	}

	@GetMapping("/certification/{certificationId}")
	public GetCertificationResponse getCertification(@PathVariable("certificationId") int certificationId) {
		Set<String> errorMessages = certificationValidationUtil.validateGetCertificationRequest(certificationId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetCertificationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.getCertification(certificationId);
		}
	}

	@GetMapping("/certifications/{employeeId}")
	public GetCertificationsResponse getCertifications(@PathVariable("employeeId") int employeeId) {
		Set<String> errorMessages = certificationValidationUtil.validateGetCertificationsRequest(employeeId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetCertificationsResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return eisService.getCertifications(employeeId);
		}
	}

}
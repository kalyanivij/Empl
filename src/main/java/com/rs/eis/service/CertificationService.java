package com.rs.eis.service;

import com.rs.eis.model.Certification;
import com.rs.eis.request.CertificationVO;
import com.rs.eis.response.CertificationResponse;
import com.rs.eis.response.DeleteCertificationResponse;
import com.rs.eis.response.EditCertificationResponse;
import com.rs.eis.response.GetCertificationResponse;
import com.rs.eis.response.GetCertificationsResponse;

public interface CertificationService {

	CertificationResponse saveCertification(CertificationVO certificationVO);

	DeleteCertificationResponse deleteCertification(int certificationId);

	GetCertificationResponse getCertification(int certificationId);

	EditCertificationResponse editCertification(Certification certification);

	GetCertificationsResponse getCertifications(int employeeId);


	// CertificationResponse certifications(@Valid CertificationVO
	// certificationsVO);

//	CertificationResponse certification(@Valid CertificationVO certificationVO);

//	CertificationResponse deleteCertification(int employeeId);

	// CertificationResponse certification(int employeeId);

}

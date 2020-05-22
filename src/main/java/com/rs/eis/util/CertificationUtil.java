package com.rs.eis.util;

import com.rs.eis.model.Certification;
import com.rs.eis.model.Timesheet;
import com.rs.eis.request.CertificationVO;
import com.rs.eis.request.TimesheetVO;

public class CertificationUtil {

	public static Certification loadCertificationVOToCertification(CertificationVO certificationVO) {
		Certification certification = new Certification();

		certification.setAcknowledgement(certificationVO.getAcknowledgement());
		certification.setType(certificationVO.getType());
		certification.setEmployeeId(certificationVO.getEmployeeId());

		certification.setEmployerId(certificationVO.getEmployerId());

		certification.setCertificationId(certificationVO.getCertificationId());
		return certification;
	}

}

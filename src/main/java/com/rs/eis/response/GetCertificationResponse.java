package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Certification;

public class GetCertificationResponse extends AbstractResponse{

		private Certification certification;

		public GetCertificationResponse() {

		}

		public GetCertificationResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
			super.setStatus(status);
			super.setStatusCode(statusCode);
			super.setErrorMessages(errorMessages);
		}

		public Certification getCertification() {
			return certification;
		}

		public void setCertification(Certification certification) {
			this.certification = certification;
	}

}

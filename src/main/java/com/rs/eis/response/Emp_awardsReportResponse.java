
package com.rs.eis.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Emp_awards;

public class Emp_awardsReportResponse extends AbstractResponse {

	private List<Emp_awards> emp_awards;

	public Emp_awardsReportResponse() {

	}

	public Emp_awardsReportResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	public List<Emp_awards> getEmp_awards() {
		return emp_awards;
	}

	public void setEmp_awards(List<Emp_awards> emp_awards) {
		this.emp_awards = emp_awards;
	}

}

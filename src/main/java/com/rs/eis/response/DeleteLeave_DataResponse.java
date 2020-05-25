package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Leave_Data;

public class DeleteLeave_DataResponse extends AbstractResponse {

	private Leave_Data leave_Data;

	

	public Leave_Data getLeave_Data() {
		return leave_Data;
	}

	public void setLeave_Data(Leave_Data leave_Data) {
		this.leave_Data = leave_Data;
	}

	public DeleteLeave_DataResponse() {

	}

	public DeleteLeave_DataResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

}

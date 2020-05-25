package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Leave_Data;
import com.rs.eis.response.AbstractResponse;

public class GetLeave_DataResponse extends AbstractResponse {
	
	public GetLeave_DataResponse() {

	}

	public GetLeave_DataResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private Leave_Data leave_Data;

	public Leave_Data getLeave_Data() {
		return leave_Data;
	}

	public void setLeave_Data(Leave_Data leave_Data) {
		this.leave_Data = leave_Data;
	}

	

	
	
	}

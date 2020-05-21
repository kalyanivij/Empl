package com.rs.eis.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

<<<<<<< HEAD
import com.rs.eis.model.Expense;
=======
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git

public class ResetPasswordResponse extends AbstractResponse {

	public ResetPasswordResponse() {

	}

	public ResetPasswordResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

}

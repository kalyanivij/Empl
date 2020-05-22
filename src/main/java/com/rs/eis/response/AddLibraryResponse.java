package com.rs.eis.response;

import java.util.Set;

import org.apache.tomcat.jni.Library;
import org.springframework.http.HttpStatus;

public class AddLibraryResponse extends AbstractResponse {

	private Library library;

	public AddLibraryResponse() {

	}

	public AddLibraryResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
	}

}

package com.rs.eis.response;

import java.util.Set;

import org.apache.tomcat.jni.Library;
import org.springframework.http.HttpStatus;

public class GetLibraryResponse extends AbstractResponse {

	public GetLibraryResponse() {

	}

	public GetLibraryResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private Library library;

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}
}

package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Resume;

public class ResumeResponse extends AbstractResponse {
	
	 private Resume resume;
	 
	 
	 
	 public ResumeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ResumeResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
			super.setStatus(status);
			super.setStatusCode(statusCode);
			super.setErrorMessages(errorMessages);
		}


	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
	
}
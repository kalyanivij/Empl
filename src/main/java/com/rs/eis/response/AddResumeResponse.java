package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Resume;

public class AddResumeResponse extends AbstractResponse {
	
	 private Resume resume;
	 
	 
	 
		public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
	
}
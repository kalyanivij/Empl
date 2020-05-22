package com.rs.eis.response;



import com.rs.eis.model.Resume;

public class EditResumeResponse extends AbstractResponse {
	
	 private Resume resume;
	 
		public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}
		
}
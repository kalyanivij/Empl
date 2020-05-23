package com.rs.eis.service;

import com.rs.eis.model.Resume;
import com.rs.eis.request.ResumeVO;
import com.rs.eis.response.AddResumeResponse;
import com.rs.eis.response.DeleteResumeResponse;
import com.rs.eis.response.EditResumeResponse;
import com.rs.eis.response.GetResumeResponse;

public interface ResumeService {
	AddResumeResponse addResume(ResumeVO resumeVO);

	DeleteResumeResponse deleteResume(int reesumeId);

	EditResumeResponse editResume(Resume resume);

	GetResumeResponse getResume(int employeeId);

}

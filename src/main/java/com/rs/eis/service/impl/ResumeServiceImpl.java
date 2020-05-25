package com.rs.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.rs.eis.model.Allocation;
import com.rs.eis.model.Resume;
import com.rs.eis.repository.EmployeeRepository;
import com.rs.eis.repository.ResumeRepository;
import com.rs.eis.request.ResumeVO;
import com.rs.eis.response.AddResumeResponse;
import com.rs.eis.response.DeleteResumeResponse;
import com.rs.eis.response.EditResumeResponse;
import com.rs.eis.response.GetResumeResponse;
import com.rs.eis.service.ResumeService;
import com.rs.eis.util.AllocationUtil;
import com.rs.eis.util.ResumeUtil;

public class ResumeServiceImpl implements ResumeService {

	@Autowired
	ResumeRepository resumeRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public AddResumeResponse addResume(ResumeVO resumeVO) {
		AddResumeResponse response = new AddResumeResponse();
		Optional<Resume> resumeObj = resumeRepository.findById(resumeVO.getEmployeeId());

		if (resumeObj.isPresent()) {
			Resume resume = ResumeUtil.loadAddResumeVoToResume(resumeVO);
			resume = resumeRepository.save(resume);

			response.setResume(resume);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Resume insertion as employeeId is not present in employee table");
		}

		return response;
	}

	@Override
	public DeleteResumeResponse deleteResume(int reesumeId) {
		DeleteResumeResponse response = new DeleteResumeResponse();

		Optional<Resume> resumeObj = resumeRepository.findById(reesumeId);

		if (resumeObj.isPresent()) {
			Resume resume = resumeObj.get();
			resumeRepository.delete(resume);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as employeeId is not present in Resume table");
		}

		return response;

	}

	@Override
	public EditResumeResponse editResume(Resume resume) {
		EditResumeResponse response = new EditResumeResponse();

		Optional<Resume> resumeObj = resumeRepository.findById(resume.getId());

		if (resumeObj.isPresent()) {

			Resume resumedb = resumeObj.get();
			resumedb = ResumeUtil.loadEditResumeVOToResume(resume, resumedb);
			resumedb = resumeRepository.save(resumedb);
			response.setResume(resumedb);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as resume is not present in resume table");
		}

		return response;

	}

	@Override
	public GetResumeResponse getResume(int employeeId) {
		GetResumeResponse response = new GetResumeResponse();
		Optional<Resume> resumeObj = resumeRepository.findById(employeeId);
		if (resumeObj.isPresent()) {
			response.setResume(resumeObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No resume Found for the given employeeId");
		}

		return response;

	}

}

package com.rs.eis.util;

import com.rs.eis.model.Resume;
import com.rs.eis.request.ResumeVO;

public class ResumeUtil {

	public static Resume loadAddResumeVoToResume(ResumeVO resumeVO) {
		Resume resume = new Resume();
		resume.setId(resumeVO.getId());
		resume.setNewResume(resumeVO.getNewResume());
		resume.setEmployeeId(resumeVO.getEmployeeId());
		resume.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
		return resume;
	}
	public static Resume loadEditResumeVOToResume(Resume resume, Resume resumedb) {
		resumedb.setNewResume(resume.getNewResume());
		resumedb.setEmployeeId(resume.getEmployeeId());

		resume.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
		return resume;

	}


}

package com.rs.eis.util;

import com.rs.eis.model.Qualification;
import com.rs.eis.request.QualificationVO;

public class FERUtil {

	public static Qualification loadQualificationVOToQualification(QualificationVO qualificationVO) {

		Qualification qualification = new Qualification();
		qualification.setEducation(qualificationVO.getEducation());
		qualification.setCourse(qualificationVO.getCourse());
		qualification.setSpecialization(qualificationVO.getSpecialization());
		qualification.setUniversity(qualificationVO.getUniversity());
		qualification.setCourse_type(qualificationVO.getCourse_type());
		qualification.setGrade(qualificationVO.getGrade());
		qualification.setMarks(qualificationVO.getMarks());

		return qualification;

	}

}

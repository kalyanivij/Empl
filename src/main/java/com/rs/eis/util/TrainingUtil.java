package com.rs.eis.util;

import com.rs.eis.model.Trainings;
import com.rs.eis.request.TrainingsVO;

public class TrainingUtil {

	public static Trainings loadTrainingVOToTrainings(TrainingsVO trainingsVO) {
		Trainings trainings = new Trainings();
		trainings.setId(trainingsVO.getId());
		trainings.setCourseType(trainingsVO.getCourseType());
		trainings.setStartDate(trainingsVO.getStartDate());
		trainings.setEndDate(trainingsVO.getEndDate());
		trainings.setDuration(trainingsVO.getDuration());
		trainings.setByWhom(trainingsVO.getByWhom());
		trainings.setEmployeeid(trainingsVO.getEmployeeId());
		trainings.setEmployerId(trainingsVO.getEmployerId());
		trainings.setCreated(trainingsVO.getCreated());
		trainings.setUpdated(trainingsVO.getUpdated());
		
		return trainings;
	}

}

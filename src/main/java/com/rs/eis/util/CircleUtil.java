package com.rs.eis.util;

import com.rs.eis.model.Circle;
import com.rs.eis.request.AddCircleVO;

public class CircleUtil {

	public static Circle loadAddCircleVOToCircle(AddCircleVO addCircleVO) {
		Circle circle = new Circle();

		circle.setId(addCircleVO.getId());
		circle.setName(addCircleVO.getName());
		circle.setOther(addCircleVO.getOther());
		circle.setEmployerid(addCircleVO.getEmployerid());
		circle.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
		circle.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
		

		return circle;

	}



}

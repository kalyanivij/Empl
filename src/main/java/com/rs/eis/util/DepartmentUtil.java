package com.rs.eis.util;

import com.rs.eis.model.Departments;
import com.rs.eis.request.AddDepartmentVO;

public class DepartmentUtil {

	public static Departments loadAddDepartmentVOToDepartment(AddDepartmentVO addDepartmentVO) {
		Departments department = new Departments();

		department.setId(addDepartmentVO.getId());
		department.setName(addDepartmentVO.getName());
		department.setEmployerid(addDepartmentVO.getEmployerid());
		department.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
		department.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
		

		return department;

	}



}

package com.rs.eis.response;

import com.rs.eis.model.Departments;

public class EditDepartmentResponse extends AbstractResponse {
	
	private Departments department;

	public Departments getDepartment() {
		return department;
	}

	public void setDepartment(Departments department) {
		this.department = department;
	}
	
	
	
	
}

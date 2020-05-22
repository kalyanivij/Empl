package com.rs.eis.response;

import com.rs.eis.model.Emp_Designation;

public class Emp_DesignationResponse extends AbstractResponse {
	private Emp_Designation emp_designation;

	public Emp_Designation getEmp_designation() {
		return emp_designation;
	}

	public void setEmp_designation(Emp_Designation emp_designation) {
		this.emp_designation = emp_designation;
	}

}

package com.rs.eis.response;

import com.rs.eis.model.Salary;

public class EditSalaryResponse extends AbstractResponse {

	private Salary salary;

	public EditSalaryResponse() {
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

}

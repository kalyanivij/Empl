package com.rs.esi.response;

import com.rs.esi.model.Emp_awards;
import com.rs.esi.model.Expense;

public class AddEmp_awardsResponse extends AbstractResponse {

	private Emp_awards emp_awards;

	public Emp_awards getEmp_awards() {
		return emp_awards;
	}

	public void setEmp_awards(Emp_awards emp_awards) {
		this.emp_awards = emp_awards;
	}

}

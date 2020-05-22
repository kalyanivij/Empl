package com.rs.eis.response;

import java.util.List;

import com.rs.eis.model.Emp_awards;

public class GetAllEmp_awardsResponse extends AbstractResponse {

	private List<Emp_awards> emp_awards;

	public List<Emp_awards> getEmp_awards() {
		return emp_awards;
	}

	public void setEmp_awards(List<Emp_awards> emp_awards) {
		this.emp_awards = emp_awards;
	}

}

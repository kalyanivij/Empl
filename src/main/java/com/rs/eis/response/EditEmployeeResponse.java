package com.rs.eis.response;

import com.rs.eis.model.Employee;

public class EditEmployeeResponse extends AbstractResponse {
	
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}

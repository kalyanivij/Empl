package com.rs.eis.response;

import com.rs.eis.model.Employee;

public class LoginResponse extends AbstractResponse {
	
	private Employee user;
	
	public Employee getUser() {
		return user;
	}
	
	public void setUser(Employee user) {
		this.user = user;
	}
	
}

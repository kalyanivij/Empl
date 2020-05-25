package com.rs.eis.response;

import com.rs.eis.model.User;

public class LoginResponse extends AbstractResponse {
	
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
}

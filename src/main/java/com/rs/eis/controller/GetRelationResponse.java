package com.rs.eis.controller;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.Relation;

public class GetRelationResponse {

	public GetRelationResponse(HttpStatus preconditionFailed, String string, Set<String> errorMessages) {
		
	}

	public GetRelationResponse() {
		// TODO Auto-generated constructor stub
	}

	public void setStatus(HttpStatus ok) {
		// TODO Auto-generated method stub
		
	}

	public void setRelation(Relation relation) {
		// TODO Auto-generated method stub
		
	}

	public void setStatusCode(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setErrorMessage(String string) {
		// TODO Auto-generated method stub
		
	}

}

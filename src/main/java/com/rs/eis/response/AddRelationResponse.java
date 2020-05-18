package com.rs.eis.response;


import com.rs.eis.model.Relation;

public class AddRelationResponse extends AbstractResponse {

	private Relation relation;

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;

	}

}
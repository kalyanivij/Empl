package com.rs.eis.response;

import com.rs.eis.model.Perfomance_review;

public class EditPerfomance_reviewResponse extends AbstractResponse {

	private Perfomance_review perfomance_review;

	public Perfomance_review getPerfomance_review() {
		return perfomance_review;
	}

	public void setPerfomance_review(Perfomance_review perfomance_review) {
		this.perfomance_review = perfomance_review;
	}

}

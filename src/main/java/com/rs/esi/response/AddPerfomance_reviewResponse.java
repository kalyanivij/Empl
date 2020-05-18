package com.rs.esi.response;

import com.rs.esi.model.Perfomance_Review;

public class AddPerfomance_reviewResponse extends AbstractResponse {

	private Perfomance_Review perfomance_review;

	public Perfomance_Review getPerfomance_review() {
		return perfomance_review;
	}

	public void setPerfomance_review(Perfomance_Review perfomance_review) {
		this.perfomance_review = perfomance_review;
	}

}

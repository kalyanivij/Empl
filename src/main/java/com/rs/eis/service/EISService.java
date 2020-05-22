package com.rs.eis.service;

import com.rs.eis.model.Perfomance_review;
import com.rs.eis.response.AddPerfomance_reviewResponse;
import com.rs.eis.response.DeletePerfomance_reviewResponse;
import com.rs.eis.response.EditPerfomance_reviewResponse;
import com.rs.eis.response.GetPerfomance_reviewResponse;

public interface EISService {

	AddPerfomance_reviewResponse addPerfomance_review(Perfomance_review perfomance_review);

	EditPerfomance_reviewResponse editPerfomance_review(Perfomance_review perfomance_review);

	GetPerfomance_reviewResponse getPerfomance_reviewByemployeeid(int employeeid);

	DeletePerfomance_reviewResponse deletePerfomance_review(int employeeid);

}

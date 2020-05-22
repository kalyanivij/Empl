package com.rs.eis.service;

import com.rs.eis.model.Visa;
import com.rs.eis.response.AddVisaResponse;
import com.rs.eis.response.DeleteVisaResponse;
import com.rs.eis.response.EditVisaResponse;

public interface VisaService {

	AddVisaResponse addVisa(Visa visa);

	EditVisaResponse editVisa(Visa visa);

	DeleteVisaResponse deleteVisa(int id);

}

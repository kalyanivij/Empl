package com.rs.eis.service;

import com.rs.eis.model.Leave_Data;
import com.rs.eis.model.Suffix;
import com.rs.eis.response.DeleteLeave_DataResponse;
import com.rs.eis.response.DeleteSuffixResponse;
import com.rs.eis.response.EditLeave_DataResponse;
import com.rs.eis.response.EditSuffixResponse;
import com.rs.eis.response.GetLeave_DataResponse;
import com.rs.eis.response.GetSuffixResponse;
import com.rs.eis.response.Leave_DataResponse;
import com.rs.eis.response.SuffixResponse;

public interface LeavedataSuffixService {

	SuffixResponse suffix(Suffix suffix);
	
	EditSuffixResponse editSuffix(Suffix suffix);

	GetSuffixResponse getSuffixById(int id);
	
	DeleteSuffixResponse deleteSuffix(int employeId);

	Leave_DataResponse leave_Data(Leave_Data leave_Data);
	
	EditLeave_DataResponse editLeave_Data(Leave_Data leave_Data);

	GetLeave_DataResponse getLeave_DataById(int id);
	
	DeleteLeave_DataResponse deleteLeave_Data(int employeId);
}

package com.rs.eis.response;

import com.rs.eis.model.Leave_Data;
import com.rs.eis.response.AbstractResponse;

public class EditLeave_DataResponse extends AbstractResponse{
	
private Leave_Data Leave_Data;

	
	public Leave_Data getLeave_Data() {
		return Leave_Data;
	}

	
	public void setLeave_Data(Leave_Data leave_Data) {
		Leave_Data = leave_Data;
	}

}

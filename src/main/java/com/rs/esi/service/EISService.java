package com.rs.esi.service;

import org.springframework.stereotype.Service;

import com.rs.esi.model.Emp_awards;
import com.rs.esi.model.Expense;
import com.rs.esi.request.RegistrationVO;
import com.rs.esi.request.UserVO;
import com.rs.esi.response.AddEmp_awardsResponse;
import com.rs.esi.response.DeleteEmp_awardsResponse;
import com.rs.esi.response.EditEmp_awardsResponse;
import com.rs.esi.response.Emp_awardsReportResponse;
import com.rs.esi.response.GetEmp_awardsResponse;
@Service
public interface EISService {
	

	
	GetEmp_awardsResponse getEmp_awardsByemployeeid(int employeeid);

	AddEmp_awardsResponse addEmp_awards(Emp_awards emp_awards);

	EditEmp_awardsResponse editEmp_awards(Emp_awards emp_awards);

	/*
	 * Emp_awardsReportResponse emp_awardsReport(int awardsid, String Date, String
	 * created, String updated);
	 */
	
	  DeleteEmp_awardsResponse deleteEmp_awards(int employeeid);
	 
}

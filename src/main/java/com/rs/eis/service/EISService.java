package com.rs.eis.service;

import org.springframework.stereotype.Service;

import com.rs.eis.model.Emp_awards;
import com.rs.eis.response.AddEmp_awardsResponse;
import com.rs.eis.response.DeleteEmp_awardsResponse;
import com.rs.eis.response.EditEmp_awardsResponse;
import com.rs.eis.response.GetAllEmp_awardsResponse;
import com.rs.eis.response.GetEmp_awardsResponse;

@Service
public interface EISService {

	GetEmp_awardsResponse getEmp_awardsByemployeeid(int employeeid);

	AddEmp_awardsResponse addEmp_awards(Emp_awards emp_awards);

	EditEmp_awardsResponse editEmp_awards(Emp_awards emp_awards);

	GetAllEmp_awardsResponse allEmp_awards(int employeeid);

	DeleteEmp_awardsResponse deleteEmp_awards(int id);

}

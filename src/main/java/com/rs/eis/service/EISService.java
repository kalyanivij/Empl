package com.rs.eis.service;

import com.rs.eis.model.Designation;
import com.rs.eis.model.Emp_Designation;
import com.rs.eis.model.Salary;
import com.rs.eis.response.DeleteDesignationResponse;
import com.rs.eis.response.DeleteEmp_DesignationResponse;
import com.rs.eis.response.DeleteSalaryResponse;
import com.rs.eis.response.DesignationResponse;
import com.rs.eis.response.EditDesignationResponse;
import com.rs.eis.response.EditEmp_DesignationResponse;
import com.rs.eis.response.EditSalaryResponse;
import com.rs.eis.response.Emp_DesignationResponse;
import com.rs.eis.response.GetDesignationResponse;
import com.rs.eis.response.GetEmp_DesignationResponse;
import com.rs.eis.response.GetSalaryResponse;
import com.rs.eis.response.SalaryResponse;

public interface EISService {
	DesignationResponse addDesignation(Designation designation);

	GetDesignationResponse getDesignationById(int id);

	DeleteDesignationResponse deleteDesignation(Integer id);

	EditDesignationResponse editDesignation(Designation designation);

	Emp_DesignationResponse addemp_designation(Emp_Designation emp_designation);

	GetEmp_DesignationResponse getemp_DesignationById(int id);

	DeleteEmp_DesignationResponse deleteemp_Designation(int id);

	SalaryResponse addSalary(Salary salary);

	EditEmp_DesignationResponse editemp_Designation(Emp_Designation emp_designation);

	EditSalaryResponse edit(Salary salary);

	GetSalaryResponse getSalaryById(int id);
	DeleteSalaryResponse deletesalary(Integer id);


}
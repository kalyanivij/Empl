package com.rs.eis.validation;

import java.util.Set;

import com.rs.eis.request.AddEmployerVO;

public interface ValidationEmployerUtil {

	Set<String> validateAddEmployerRequest(AddEmployerVO addEmployerVO);

	Set<String> validateGetEmployeesRequest(int id);

}

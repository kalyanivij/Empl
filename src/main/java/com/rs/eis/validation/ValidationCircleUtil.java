package com.rs.eis.validation;

import java.util.Set;

import com.rs.eis.request.AddCircleVO;

public interface ValidationCircleUtil {
	
	Set<String> validateAddCircleRequest(AddCircleVO addCircleVO);

	Set<String> validateGetCircleRequest(int id);

	Set<String> validateDeleteCircleRequest(int id);

	Set<String> validateGetCirclesRequest(Integer id);
}

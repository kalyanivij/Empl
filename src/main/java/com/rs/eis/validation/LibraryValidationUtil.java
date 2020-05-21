package com.rs.eis.validation;

import java.util.Set;

import com.rs.eis.request.AddLibraryVO;

public interface LibraryValidationUtil {

	Set<String> validateAddLibraryRequest(AddLibraryVO addlibraryVO);

	
	Set<String> validateGetLibraryRequest(int id);

	Set<String> validateEditLibraryRequest(int id);

	Set<String> validateDeleteLibraryRequest(int id);

}

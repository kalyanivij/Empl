package com.rs.eis.validation;

import java.util.Set;



import com.rs.eis.request.AddBookVO;

public interface BookValidationUtil {
	Set<String> validateAddBookRequest(AddBookVO addbookVO);

	
	  Set<String> validateGetBookRequest(int id);
	  
	  Set<String> validateEditBookRequest(int id); 
	  
	  Set<String> validateDeleteBookRequest(int id);
	  
	 

}

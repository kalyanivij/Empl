package com.rs.eis.service;

import com.rs.eis.model.Library;
import com.rs.eis.request.AddLibraryVO;
import com.rs.eis.response.AddLibraryResponse;
import com.rs.eis.response.DeleteLibraryResponse;
import com.rs.eis.response.EditLibraryResponse;
import com.rs.eis.response.GetLibraryResponse;

public interface LibraryService {
	
	AddLibraryResponse addLibraryResponse(AddLibraryVO addLibraryVO);

	
	  EditLibraryResponse editLibrary(Library library);
	  
	  GetLibraryResponse getLibraryById(int id);
	  
	  DeleteLibraryResponse deleteLibrary(int id);
	 
}

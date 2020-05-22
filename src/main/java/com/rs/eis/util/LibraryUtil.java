package com.rs.eis.util;

import com.rs.eis.model.Library;
import com.rs.eis.request.AddLibraryVO;

public class LibraryUtil {
	public static Library loadAddLibraryVOToLibrary(AddLibraryVO addLibraryVO) {
		Library library = new Library();

		library.setDate(addLibraryVO.getDate());
		library.setDateReturn(addLibraryVO.getDateReturn());

		library.setBookid(addLibraryVO.getBookid());


		return library;

	}


}

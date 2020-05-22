package com.rs.eis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.eis.model.Library;
import com.rs.eis.repository.LibraryRepository;
import com.rs.eis.request.AddLibraryVO;
import com.rs.eis.response.AddLibraryResponse;
import com.rs.eis.response.DeleteLibraryResponse;
import com.rs.eis.response.EditLibraryResponse;
import com.rs.eis.response.GetLibraryResponse;
import com.rs.eis.service.LibraryService;
import com.rs.eis.util.DateUtil;
import com.rs.eis.util.LibraryUtil;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	public LibraryRepository libraryRepository;

	@Override
	public AddLibraryResponse addLibraryResponse(AddLibraryVO addLibraryVO) {

		AddLibraryResponse response = new AddLibraryResponse();

		List<Library> librarysobj = libraryRepository.findByBookid(addLibraryVO.getBookid());

		if (librarysobj.isEmpty()) {

			Library library = LibraryUtil.loadAddLibraryVOToLibrary(addLibraryVO);

			library = libraryRepository.save(library);

			response.setLibrary(library);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Library is already registered");
		}

		return response;
	}

	@Override
	public EditLibraryResponse editLibrary(Library library) {
		EditLibraryResponse response = new EditLibraryResponse();

		Optional<Library> librarysobj = libraryRepository.findById(library.getId());

		if (librarysobj.isPresent()) {

			library.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			library = libraryRepository.save(library);

			response.setLibrary(library);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as employeeId is not present in employee table");
		}

		return response;
	}

	@Override
	public GetLibraryResponse getLibraryById(int id) {

		GetLibraryResponse response = new GetLibraryResponse();
		Optional<Library> librarysobj = libraryRepository.findById(id);
		if (librarysobj.isPresent()) {
			response.setLibrary(librarysobj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No Employee Found for the given employeeid");
		}

		return response;
	}

	@Override
	public DeleteLibraryResponse deleteLibrary(int id){
		DeleteLibraryResponse response = new DeleteLibraryResponse();

		Optional<Library> librarysobj = libraryRepository.findById(id);

		if (librarysobj.isPresent()) {
			Library library = librarysobj.get();
			libraryRepository.delete(library);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as employeeId is not present in employee table");
		}

		return response;

	}

}

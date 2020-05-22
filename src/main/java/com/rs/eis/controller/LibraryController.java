package com.rs.eis.controller;


import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.eis.model.Library;
import com.rs.eis.repository.LibraryRepository;
import com.rs.eis.request.AddLibraryVO;
import com.rs.eis.response.AddLibraryResponse;
import com.rs.eis.response.DeleteLibraryResponse;
import com.rs.eis.response.EditLibraryResponse;
import com.rs.eis.response.GetLibraryResponse;
import com.rs.eis.service.LibraryService;
import com.rs.eis.validation.LibraryValidationUtil;

@RestController
@RequestMapping("/eis")
public class LibraryController {

	@Autowired
	LibraryService libraryService;

	@Autowired
	LibraryValidationUtil libraryValidationUtil;

	@Autowired
	LibraryRepository libraryRepository;

//private int bookid;

	@PostMapping("/addlibrary")
	public AddLibraryResponse addLibraryResponse(@Valid @RequestBody AddLibraryVO addLibraryVO) {

		Set<String> errorMessages = libraryValidationUtil.validateAddLibraryRequest(addLibraryVO);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new AddLibraryResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return libraryService.addLibraryResponse(addLibraryVO);
		}
	}

	@PutMapping("/library/{id}")
	public EditLibraryResponse editEmployee(@PathVariable("id") int id, @Valid @RequestBody Library library) {
		/*
		 * Set<String> errorMessages =
		 * libraryValidationUtil.validateEditEmployeeRequest(id); if
		 * (!CollectionUtils.isEmpty(errorMessages)) { return new
		 * EditEmployeeResponse(); } else {
		 */
		return libraryService.editLibrary(library);
	}

	@DeleteMapping("/library/{id}")
	public DeleteLibraryResponse deleteLibrary(@PathVariable(value = "id") int id) {
		Set<String> errorMessages = libraryValidationUtil.validateDeleteLibraryRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteLibraryResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return libraryService.deleteLibrary(id);
		}
	}

	@GetMapping("/library/{id}")
	public GetLibraryResponse getLibraryById(@PathVariable("id") int id) {
		Set<String> errorMessages = libraryValidationUtil.validateGetLibraryRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetLibraryResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return libraryService.getLibraryById(id);
		}
	}
}

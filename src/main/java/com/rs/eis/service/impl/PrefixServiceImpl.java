package com.rs.eis.service.impl;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.rs.eis.model.Prefix;
import com.rs.eis.repository.PrefixRepository;
import com.rs.eis.response.DeletePrefixResponse;
import com.rs.eis.response.EditPrefixResponse;
import com.rs.eis.response.GetPrefixResponse;
import com.rs.eis.response.PrefixResponse;
import com.rs.eis.service.PrefixService;
import com.rs.eis.util.DateUtil;

public class PrefixServiceImpl implements PrefixService{
	@Autowired
	PrefixRepository prefixRespository;

	public PrefixResponse prefix(Prefix prefix) {

		PrefixResponse response = new PrefixResponse();

		Optional<Prefix> prefixObj = prefixRespository.findById(prefix.getId());

		if (prefixObj.isPresent()) {

			prefix.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			prefix = prefixRespository.save(prefix);

			response.setPrefix(prefix);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input Employ not registered");
		}

		return response;
	}

	@Override
	public EditPrefixResponse editPrefix(Prefix prefix) {
		EditPrefixResponse response = new EditPrefixResponse();

		Optional<Prefix> prefixObj = prefixRespository.findById(prefix.getId());

		if (prefixObj.isPresent()) {

			prefix.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			prefix =prefixRespository.save(prefix);

			response.setPrefix(prefix);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as expenseId is not present in expense table");
		}

		return response;
	}

	@Override
	public DeletePrefixResponse deletePrefix(int employeId) {
		DeletePrefixResponse response = new DeletePrefixResponse();
		Optional<Prefix> prefixObj = prefixRespository.findById(employeId);
		if (prefixObj.isPresent()) {
			Prefix prefix = prefixObj.get();
			prefixRespository.delete(prefix);
		response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
	} else {
		response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as prefixId is not present in expense table");
	}
		return response;
	}

	@Override
	public GetPrefixResponse getPrefixById(int id) {
		GetPrefixResponse response = new GetPrefixResponse();
		Optional<Prefix> prefixObj = prefixRespository.findById(id);

		if (prefixObj.isPresent()) {
			response.setPrefix(prefixObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No Expense Found for the given suffixid");
		}
		return response;
	}
	

}

package com.rs.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.eis.model.Leave_Data;
import com.rs.eis.model.Suffix;
import com.rs.eis.repository.Leave_DataRepository;
import com.rs.eis.repository.SuffixRepository;
import com.rs.eis.response.DeleteLeave_DataResponse;
import com.rs.eis.response.DeleteSuffixResponse;
import com.rs.eis.response.EditLeave_DataResponse;
import com.rs.eis.response.EditSuffixResponse;
import com.rs.eis.response.GetLeave_DataResponse;
import com.rs.eis.response.GetSuffixResponse;
import com.rs.eis.response.Leave_DataResponse;
import com.rs.eis.response.SuffixResponse;
import com.rs.eis.service.LeavedataSuffixService;
import com.rs.eis.util.DateUtil;

@Service
public class LeavedataSuffixServiceImpl implements LeavedataSuffixService {

	@Autowired
	SuffixRepository suffixRepository;

	@Autowired
	Leave_DataRepository leave_DataRepository;

	@Override
	public SuffixResponse suffix(Suffix suffix) {

		SuffixResponse response = new SuffixResponse();

		Optional<Suffix> suffixObj = suffixRepository.findById(suffix.getId());

		if (suffixObj.isPresent()) {

			suffix.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			suffix = suffixRepository.save(suffix);

			response.setSuffix(suffix);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input suffix not registered");
		}

		return response;
	}

	@Override
	public GetSuffixResponse getSuffixById(int id) {

		GetSuffixResponse response = new GetSuffixResponse();
		Optional<Suffix> suffixObj = suffixRepository.findById(id);

		if (suffixObj.isPresent()) {
			response.setSuffix(suffixObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No Expense Found for the given suffixid");
		}

		return response;
	}
	
	@Override
	public DeleteSuffixResponse deleteSuffix(int employeId) {

		DeleteSuffixResponse response = new DeleteSuffixResponse();
		Optional<Suffix> suffixObj = suffixRepository.findById(employeId);
		if (suffixObj.isPresent()) {
			Suffix suffix = suffixObj.get();
			suffixRepository.delete(suffix);
		response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
	} else {
		response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as suffixId is not present in expense table");
	}

	return response;

	}

	@Override
	public Leave_DataResponse leave_Data(Leave_Data leave_Data) {

		Leave_DataResponse response = new Leave_DataResponse();

		Optional<Leave_Data> leave_DataObj = leave_DataRepository.findById(leave_Data.getId());

		if (leave_DataObj.isPresent()) {

			leave_Data = leave_DataRepository.save(leave_Data);

			response.setLeave_Data(leave_Data);

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
	public GetLeave_DataResponse getLeave_DataById(int id) {

		GetLeave_DataResponse response = new GetLeave_DataResponse();
		Optional<Leave_Data> leave_DataObj = leave_DataRepository.findById(id);


		if (leave_DataObj.isPresent()) {
			response.setLeave_Data(leave_DataObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No Expense Found for the given suffixid");
		}

		return response;
	}
	
	@Override
	public DeleteLeave_DataResponse deleteLeave_Data(int employeId) {
		
		DeleteLeave_DataResponse response = new DeleteLeave_DataResponse();
		Optional<Leave_Data> leave_DataObj = leave_DataRepository.findById(employeId);
		if (leave_DataObj.isPresent()) {
			Leave_Data leave_Data = leave_DataObj.get();
			leave_DataRepository.delete(leave_Data);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as suffixId is not present in expense table");
		}

		return response;

	}

	@Override
	public EditSuffixResponse editSuffix(Suffix suffix) {
		
		EditSuffixResponse response = new EditSuffixResponse();

			Optional<Suffix> suffixObj = suffixRepository.findById(suffix.getId());

			if (suffixObj.isPresent()) {

				suffix.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
				suffix = suffixRepository.save(suffix);

				response.setSuffix(suffix);

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
	public EditLeave_DataResponse editLeave_Data(Leave_Data leave_Data) {
		EditLeave_DataResponse response = new EditLeave_DataResponse();

			Optional<Leave_Data> leave_DataObj = leave_DataRepository.findById(leave_Data.getId());

			if (leave_DataObj.isPresent()) {

				leave_Data.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
				leave_Data = leave_DataRepository.save(leave_Data);

				response.setLeave_Data(leave_Data);

				response.setStatusCode("000");
				response.setStatus(HttpStatus.OK);
			} else {
				response.setStatusCode("001");
				response.setStatus(HttpStatus.PRECONDITION_FAILED);
				response.setErrorMessage("Invalid Input as expenseId is not present in expense table");
			}

			return response;
		}

}

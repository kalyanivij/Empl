package com.rs.eis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.eis.model.Donation;

import com.rs.eis.repository.DonationRepository;
import com.rs.eis.request.DonationVO;
import com.rs.eis.response.DeleteDonationResponse;
import com.rs.eis.response.DonationResponse;
import com.rs.eis.response.EditDonationResponse;
import com.rs.eis.response.GetDonationResponse;
import com.rs.eis.service.DonationService;
import com.rs.eis.util.DonationUtil;

@Service
public class DonationServiceImpl implements DonationService {

	@Autowired
	DonationRepository donationRepository;

	@Override
	public DonationResponse donation(DonationVO donationVO) {

		DonationResponse response = new DonationResponse();
		List<Donation> obj = donationRepository.findByCode(donationVO.getCode());

		if (CollectionUtils.isEmpty(obj)) {

			Donation donation = DonationUtil.loadDonationVO(donationVO);

			donation = donationRepository.save(donation);

			response.setDonation(donation);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("User is already registered");
		}
		return response;

	}

	@Override
	public GetDonationResponse getDonationById(int id) {
		GetDonationResponse response = new GetDonationResponse();
		Optional<Donation> dObj = donationRepository.findById(id);
		if (dObj.isPresent()) {
			response.setDonation(dObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No data Found for the given id");
		}

		return response;
	}

	@Override
	public EditDonationResponse editDonation(Donation donation) {
		EditDonationResponse response = new EditDonationResponse();

		Optional<Donation> dObj = donationRepository.findById(donation.getId());

		if (dObj.isPresent()) {

			donation = donationRepository.save(donation);

			response.setDonation(donation);

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
	public DeleteDonationResponse deleteDonation(Integer id) {

		DeleteDonationResponse response = new DeleteDonationResponse();

		Optional<Donation> dObj = donationRepository.findById(id);

		if (dObj.isPresent()) {
			Donation Donation = dObj.get();
			donationRepository.delete(Donation);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in donation table");
		}
		return response;
	}

}

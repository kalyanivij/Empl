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
import com.rs.eis.model.Donation;
import com.rs.eis.repository.DonationRepository;
import com.rs.eis.request.DonationVO;
import com.rs.eis.response.DeleteDonationResponse;
import com.rs.eis.response.DonationResponse;
import com.rs.eis.response.EditDonationResponse;
import com.rs.eis.response.GetDonationResponse;
import com.rs.eis.service.DonationService;
import com.rs.eis.validation.DonationValidationUtil;

@RestController
@RequestMapping("/api")
public class DonationController {

	@Autowired
	DonationService donationService;

	@Autowired
	DonationRepository donationRepository;

	@Autowired
	DonationValidationUtil donationvalidationUtil;

	@PostMapping("/donation")
	public DonationResponse donation(@Valid @RequestBody DonationVO donationVO) {
		return donationService.donation(donationVO);
	}

	@GetMapping("/donation/{id}")
	public GetDonationResponse getDonationById(@PathVariable("id") int id) {
		Set<String> errorMessages = donationvalidationUtil.validateGetDonationRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetDonationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return donationService.getDonationById(id);
		}
	}

	@PutMapping("/donation/{id}")
	public EditDonationResponse editDonation(@PathVariable(value = "id") int id,
			@Valid @RequestBody Donation donation) {
		return donationService.editDonation(donation);
	}

	@DeleteMapping("/donation/{id}")
	public DeleteDonationResponse deleteDonation(@PathVariable(value = "id") int id) {
		Set<String> errorMessages = donationvalidationUtil.validateDeleteDonationRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteDonationResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return donationService.deleteDonation(id);
		}
	}
}
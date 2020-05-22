package com.rs.eis.service;

import com.rs.eis.model.Donation;
import com.rs.eis.request.DonationVO;
import com.rs.eis.response.DeleteDonationResponse;
import com.rs.eis.response.DonationResponse;
import com.rs.eis.response.EditDonationResponse;
import com.rs.eis.response.GetDonationResponse;

public interface DonationService {

	DonationResponse donation(DonationVO donationVO);

	GetDonationResponse getDonationById(int id);

	EditDonationResponse editDonation(Donation donation);

	DeleteDonationResponse deleteDonation(Integer id);

}

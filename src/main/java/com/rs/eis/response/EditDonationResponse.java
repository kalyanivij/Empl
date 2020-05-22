package com.rs.eis.response;

import com.rs.eis.model.Donation;

public class EditDonationResponse extends AbstractResponse {
	
	private Donation donation;
	
	public Donation getDonation() {
		return donation;
	}
	
	public void setDonation(Donation donation) {
		this.donation = donation;
	}
}

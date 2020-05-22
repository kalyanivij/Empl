package com.rs.eis.util;

import com.rs.eis.model.Donation;
import com.rs.eis.request.DonationVO;

public class DonationUtil {

	public static Donation loadDonationVO(DonationVO donationVO) {

		Donation donation = new Donation();

		donation.setCode(donationVO.getCode());
		donation.setValue(donationVO.getValue());

		donation.setCreatedAt(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
		donation.setUpdatedAt(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));

		return donation;

	}

}

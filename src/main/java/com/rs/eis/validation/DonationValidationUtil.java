package com.rs.eis.validation;

import java.util.Set;

public interface DonationValidationUtil {

	Set<String> validateGetDonationRequest(int id);

	Set<String> validateDeleteDonationRequest(int id);

}

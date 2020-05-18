package com.rs.eis.response;

import com.rs.eis.model.Beneficiary;
import com.rs.eis.model.Expense;

public class AddBeneficiaryResponse extends AbstractResponse{
private Beneficiary beneficiary;
	
	public Beneficiary getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}
}

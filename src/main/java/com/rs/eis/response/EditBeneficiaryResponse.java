package com.rs.eis.response;

import com.rs.eis.model.Beneficiary;

public class EditBeneficiaryResponse extends AbstractResponse{
private Beneficiary beneficiary;
	
	public Beneficiary getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}
	public void setExpense(Beneficiary beneficiary2) {
		// TODO Auto-generated method stub
		this.beneficiary = beneficiary;

	}
}

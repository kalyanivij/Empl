package com.rs.eis.response;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.EmpAssets;
import com.rs.eis.model.User;

public class GetAssetsReponse extends AbstractResponse {

	public GetAssetsReponse() {

	}

	public GetAssetsReponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}

	private EmpAssets assets;

	public EmpAssets getAssets() {
		return assets;
	}

	public void setAssets(EmpAssets assets) {
		this.assets = assets;
	}
	


}

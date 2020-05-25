package com.rs.eis.response;
   
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.eis.model.EmpAssets;

public class DeleteEmpAssetsResponse extends AbstractResponse{

	private EmpAssets empassets;

	public EmpAssets getEmpassets() {
		return empassets;
	}

	public void setEmpassets(EmpAssets empassets) {
		this.empassets = empassets;
	}
	public DeleteEmpAssetsResponse(){
		
	}
	public DeleteEmpAssetsResponse(HttpStatus status, String statusCode, Set<String> errorMessages) {
		super.setStatus(status);
		super.setStatusCode(statusCode);
		super.setErrorMessages(errorMessages);
	}
}

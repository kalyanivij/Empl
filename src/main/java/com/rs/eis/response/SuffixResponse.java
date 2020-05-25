package com.rs.eis.response;

import com.rs.eis.model.Suffix;
import com.rs.eis.response.AbstractResponse;

public class SuffixResponse extends AbstractResponse {
	
	private Suffix Suffix;

	public Suffix getSuffix() {
		return Suffix;
	}

	public void setSuffix(Suffix suffix) {
		Suffix = suffix;
	}

}

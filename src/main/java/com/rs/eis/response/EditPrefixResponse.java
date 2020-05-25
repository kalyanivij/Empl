package com.rs.eis.response;

import com.rs.eis.model.Prefix;

public class EditPrefixResponse  extends AbstractResponse{
	private Prefix prefix;

	public Prefix getPrefix() {
		return prefix;
	}

	public void setPrefix(Prefix prefix) {
		this.prefix = prefix;
	}

}

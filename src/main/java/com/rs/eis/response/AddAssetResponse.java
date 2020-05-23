package com.rs.eis.response;

import com.rs.eis.model.Asset;

public class AddAssetResponse extends AbstractResponse {

	private Asset asset;

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}
}

package com.rs.eis.service;

import com.rs.eis.model.Asset;
import com.rs.eis.response.AddAssetResponse;
import com.rs.eis.response.AssetResponse;
import com.rs.eis.response.DeleteAssetResponse;
import com.rs.eis.response.EditAssetResponse;

public interface AssetService {

	AddAssetResponse addAsset(Asset asset);

	AssetResponse getAssetById(int id);

	EditAssetResponse editAsset(Asset asset);

	DeleteAssetResponse deleteAsset(int assetId);
}

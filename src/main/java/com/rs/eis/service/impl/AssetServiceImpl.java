package com.rs.eis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.eis.model.Asset;
import com.rs.eis.repository.AssetRepository;
import com.rs.eis.response.AddAssetResponse;
import com.rs.eis.response.AssetResponse;
import com.rs.eis.response.DeleteAssetResponse;
import com.rs.eis.response.EditAssetResponse;
import com.rs.eis.service.AssetService;
import com.rs.eis.util.DateUtil;

@Service
public class AssetServiceImpl implements AssetService {

	@Autowired
	AssetRepository assetRepository;

	@Override
	public AddAssetResponse addAsset(Asset asset) {
		AddAssetResponse response = new AddAssetResponse();

		Optional<Asset> assetObj = assetRepository.findById(asset.getId());

		if (!assetObj.isPresent()) {

			asset.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			asset = assetRepository.save(asset);

			response.setAsset(asset);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as assetId is not present in asset table");
		}

		return response;
	}

	@Override
	public EditAssetResponse editAsset(Asset asset) {
		EditAssetResponse response = new EditAssetResponse();

		Optional<Asset> expenseObj = assetRepository.findById(asset.getId());

		if (expenseObj.isPresent()) {

			asset.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			asset = assetRepository.save(asset);

			response.setAsset(asset);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as assetId is not present in Asset table");
		}

		return response;
	}

	@Override
	public DeleteAssetResponse deleteAsset(int assetId) {
		DeleteAssetResponse response = new DeleteAssetResponse();

		Optional<Asset> expenseObj = assetRepository.findById(assetId);

		if (expenseObj.isPresent()) {
			Asset asset = expenseObj.get();
			assetRepository.delete(asset);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as assetId is not present in Asset table");
		}

		return response;
	}

	@Override
	public AssetResponse getAssetById(int id) {
		AssetResponse response = new AssetResponse();
		Optional<Asset> assetObj = assetRepository.findById(id);
		if (!assetObj.isPresent()) {
			response.setAsset(assetObj.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as assetId is not present in asset table");
		}

		return response;
	}

}

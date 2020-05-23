package com.rs.eis.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.eis.model.Asset;
import com.rs.eis.repository.AssetRepository;
import com.rs.eis.response.AddAssetResponse;
import com.rs.eis.response.AssetResponse;
import com.rs.eis.response.DeleteAssetResponse;
import com.rs.eis.response.EditAssetResponse;
import com.rs.eis.service.AssetService;
import com.rs.eis.validation.ValidationAssetUtil;

@RestController
@RequestMapping("/eis")
public class AssetController {
	@Autowired
	AssetService employeeService;

	@Autowired
	ValidationAssetUtil validationUtil;

	@Autowired
	AssetRepository assetRepository;

	//private int id;
	

	@PostMapping("/asset")
	public AddAssetResponse addExpense(@Valid @ModelAttribute Asset asset) {
		return employeeService.addAsset(asset);
	}

	@PutMapping("/asset/{id}")
	public EditAssetResponse editAsset(@PathVariable("id") int Id, @Valid @RequestBody Asset asset) {
		return employeeService.editAsset(asset);
	}

	@DeleteMapping("/asset/{assetId}")
	public DeleteAssetResponse deleteAsset(@PathVariable(value = "assetId") int assetId) {
		Set<String> errorMessages = validationUtil.validateDeleteAssetRequest(assetId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeleteAssetResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return employeeService.deleteAsset(assetId);
		}
	}

	@GetMapping("/asset/{id}")
	public AssetResponse getAssetById(@PathVariable("id") int id) {
		Set<String> errorMessages = validationUtil.validateGetAssetRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new AssetResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return employeeService.getAssetById(id);
		}
	}

}

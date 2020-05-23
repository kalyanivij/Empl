package com.rs.eis.validation.impl;

import java.util.HashSet;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.eis.validation.ValidationAssetUtil;

@Component
public class ValidationAssetUtilImpl implements ValidationAssetUtil {

	public Set<String> validateGetAssetRequest(int id) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, id, "Please enter valid Id");

		return errorMessages;
	}

	private void addError(Set<String> errorMessages, int id, String string) {

	}

	@Override
	public Set<String> validateDeleteAssetRequest(int assetId) {
		return validateGetAssetRequest(assetId);
	}

}

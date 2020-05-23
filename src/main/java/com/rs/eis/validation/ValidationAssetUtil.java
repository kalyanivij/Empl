package com.rs.eis.validation;

import java.util.Set;

public interface ValidationAssetUtil {

	Set<String> validateGetAssetRequest(int id);

	Set<String> validateDeleteAssetRequest(int assetId);

}

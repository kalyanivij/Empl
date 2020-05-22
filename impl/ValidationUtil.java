package com.rs.eis.validation.impl;

import java.util.Set;

import com.rs.eis.request.RegistrationVO;

public interface ValidationUtil {
	Set<String> validateRegistrationRequest(RegistrationVO registrationVO);

}

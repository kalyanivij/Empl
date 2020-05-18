package com.rs.esi.validation.impl;

import java.util.Set;

import com.rs.esi.request.RegistrationVO;

public interface ValidationUtil {
	Set<String> validateRegistrationRequest(RegistrationVO registrationVO);

}

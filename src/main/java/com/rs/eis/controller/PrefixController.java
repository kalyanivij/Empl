package com.rs.eis.controller;


import java.util.Set;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.eis.model.Prefix;
import com.rs.eis.repository.PrefixRepository;
import com.rs.eis.response.DeletePrefixResponse;
import com.rs.eis.response.EditPrefixResponse;
import com.rs.eis.response.GetPrefixResponse;
import com.rs.eis.response.PrefixResponse;
import com.rs.eis.service.PrefixService;
import com.rs.eis.validation.PrefixValidationUtil;
import com.rs.eis.validation.ValidationUtil;


@RestController
@RequestMapping("/api")
public class PrefixController {
	
	
	@Autowired
	PrefixService prefixService;
	@Autowired
	PrefixValidationUtil prefixValidationUtil;
	@Autowired
	PrefixRepository prefixRepository;
    private int employeId;
	
	@PostMapping("/addprefix")
	public PrefixResponse prefix(@Valid @RequestBody  Prefix prefix) {
		return prefixService.prefix(prefix);
	}
	
	@PutMapping("/prefix/{id}")
	public EditPrefixResponse editPrefix(@PathVariable("id") int Id, @Valid @RequestBody Prefix prefix) {
		return prefixService.editPrefix(prefix);
	}

	@GetMapping("/prefix/{id}")
	public GetPrefixResponse getPrefixById(@PathVariable("id") int id) {
		Set<String> errorMessages =prefixValidationUtil.validateGetPrefixRequest(id);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new GetPrefixResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return prefixService.getPrefixById(id);
		}
	}
	
	@DeleteMapping("/prefix/{employeId}")
	public DeletePrefixResponse deletePrefix(@PathVariable(value = "employeId") int employeId) {
		Set<String> errorMessages = prefixValidationUtil.validateDeletePrefixRequest(employeId);
		if (!CollectionUtils.isEmpty(errorMessages)) {
			return new DeletePrefixResponse(HttpStatus.PRECONDITION_FAILED, "999", errorMessages);
		} else {
			return prefixService.deletePrefix(employeId);
		}
	}

}

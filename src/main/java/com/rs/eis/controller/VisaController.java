
package com.rs.eis.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.eis.model.Visa;
import com.rs.eis.response.AddVisaResponse;
import com.rs.eis.response.DeleteVisaResponse;
import com.rs.eis.response.EditVisaResponse;
import com.rs.eis.service.VisaService;
import com.rs.eis.validation.ValidationUtil;

@RestController
@RequestMapping("/eis")
public class VisaController {
	@Autowired
	VisaService visaService;
	

	@PostMapping("/addVisa")
	public AddVisaResponse addvisa(@Valid @RequestBody Visa visa) {
		return visaService.addVisa(visa);
	}

	@PutMapping("/editVisa/{id}")
	public EditVisaResponse editvisa(@PathVariable(value = "id") int Id, @Valid @RequestBody Visa visa) {
		return visaService.editVisa(visa);
	}

	@DeleteMapping("/deleteVisa/{id}")
	public DeleteVisaResponse deletVisa(@PathVariable("id") int id) {
		Set<String> errorMessages = ValidationUtil.validateDeletevisaRequest("id");
		return visaService.deleteVisa(id);

	}
}

package com.svcet.cashportal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.svcet.cashportal.domain.OrganizationMaster;
import com.svcet.cashportal.service.OraganizationService;
import com.svcet.cashportal.web.beans.OrganizationReponse;
import com.svcet.cashportal.web.beans.OrganizationRequest;

@RestController
public class OrganizationController {

	@Autowired
	private OraganizationService oraganizationService;

	@RequestMapping(method = RequestMethod.POST, value = "/organization/save")
	@ResponseBody
	public OrganizationMaster save(@RequestBody OrganizationRequest organizationRequest) {
		return oraganizationService.save(organizationRequest);
	}

	@RequestMapping("/organization/{id}")
	public OrganizationReponse findOne(@PathVariable("id") String id) {
		return oraganizationService.findById(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/organization/update")
	public OrganizationReponse update(@RequestBody OrganizationRequest organizationRequest) {
		return oraganizationService.update(organizationRequest);
	}
}

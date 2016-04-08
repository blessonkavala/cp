package com.svcet.cashportal.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.svcet.cashportal.domain.OrganizationMaster;
import com.svcet.cashportal.security.config.UserNamePasswordOrganizationAuthenticationToken;
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
		organizationRequest.setOrgType(getSubOrgType(getLoggedInUserOrgType()));
		return oraganizationService.save(organizationRequest);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/organization/query")
	public OrganizationReponse findOne(@RequestBody OrganizationRequest organizationRequest) {
		return oraganizationService.findById(organizationRequest.getRid());
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/organization/update")
	public OrganizationReponse update(@RequestBody OrganizationRequest organizationRequest) {
		organizationRequest.setOrgType(getSubOrgType(getLoggedInUserOrgType()));
		return oraganizationService.update(organizationRequest);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/organization/list")
	@ResponseBody
	public OrganizationReponse[] findAll() {
		List<OrganizationReponse> organizationReponseList = oraganizationService
				.findAll(getSubOrgType(getLoggedInUserOrgType()));
		return organizationReponseList.toArray(new OrganizationReponse[organizationReponseList.size()]);
	}

	public String getLoggedInUserOrgType() {
		UserNamePasswordOrganizationAuthenticationToken authenticationToken = (UserNamePasswordOrganizationAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();
		final String orgName = authenticationToken.getOrganization();
		OrganizationMaster organizationMaster = oraganizationService.findByOrgName(orgName);
		return organizationMaster.getOrgType();
	}

	public String getSubOrgType(String superOrgType) {
		String subOrgType = null;
		switch (superOrgType) {
		case "BANK_GROUP":
			subOrgType = "BANK";
			break;
		case "BANK":
			subOrgType = "CUSTOMER";
		}
		return subOrgType;
	}

}

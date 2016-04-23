package com.svcet.cashportal.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.svcet.cashportal.domain.OrganizationMaster;
import com.svcet.cashportal.service.OraganizationService;
import com.svcet.cashportal.utils.OrganizationUtils;
import com.svcet.cashportal.web.beans.OrganizationReponse;
import com.svcet.cashportal.web.beans.OrganizationRequest;

@RestController
public class OrganizationController {

	@Autowired
	private OraganizationService oraganizationService;

	@Autowired
	private OrganizationUtils organizationUtils;

	@RequestMapping(method = RequestMethod.POST, value = "/organization/save")
	@ResponseBody
	public OrganizationMaster save(@RequestBody OrganizationRequest organizationRequest) {
		organizationRequest.setOrgType(OrganizationUtils.getSubOrgType(organizationUtils.getLoggedInUserOrgType()));
		OrganizationMaster organizationMaster = organizationUtils.getLoggedInUserOrg();
		organizationRequest.setParentOrgId(organizationMaster.getRid());
		return oraganizationService.save(organizationRequest);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/organization/query")
	public OrganizationReponse findOne(@RequestBody OrganizationRequest organizationRequest) {
		return oraganizationService.findById(organizationRequest.getRid());
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/organization/update")
	public OrganizationReponse update(@RequestBody OrganizationRequest organizationRequest) {
		organizationRequest.setOrgType(OrganizationUtils.getSubOrgType(organizationUtils.getLoggedInUserOrgType()));
		return oraganizationService.update(organizationRequest);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/organization/list")
	@ResponseBody
	public OrganizationReponse[] findAll() {
		List<OrganizationReponse> organizationReponseList = oraganizationService
				.findAll(OrganizationUtils.getSubOrgType(organizationUtils.getLoggedInUserOrgType()));
		return organizationReponseList.toArray(new OrganizationReponse[organizationReponseList.size()]);
	}

}

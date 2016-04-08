package com.svcet.cashportal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.svcet.cashportal.service.OrganizationRolesService;
import com.svcet.cashportal.web.beans.OrganizationRequest;
import com.svcet.cashportal.web.beans.OrganizationRolesScreenRequest;
import com.svcet.cashportal.web.beans.OrganizationRolesScreenResponse;

@RestController
public class OrganizationRoleController {

	@Autowired
	private OrganizationRolesService organizationRolesService;

	@RequestMapping(method = RequestMethod.POST, value = "/orgroles/query")
	public OrganizationRolesScreenResponse findAll(@RequestBody OrganizationRequest organizationRequest) {
		return organizationRolesService.editOrganizationRoles(organizationRequest);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/orgroles/update")
	public void update(@RequestBody OrganizationRolesScreenRequest organizationRolesScreenRequest) {
		 organizationRolesService.updateOrganizationRoles(organizationRolesScreenRequest);
	}

}

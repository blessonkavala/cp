package com.svcet.cashportal.service;

import java.util.List;

import com.svcet.cashportal.web.beans.OrganizationRequest;
import com.svcet.cashportal.web.beans.OrganizationRoleVO;
import com.svcet.cashportal.web.beans.OrganizationRolesScreenRequest;
import com.svcet.cashportal.web.beans.OrganizationRolesScreenResponse;

public interface OrganizationRolesService {

	List<OrganizationRoleVO> findById(String organizationId);

	OrganizationRolesScreenResponse editOrganizationRoles(OrganizationRequest organizationRequest);

	void updateOrganizationRoles(OrganizationRolesScreenRequest organizationRolesScreenRequest);

}

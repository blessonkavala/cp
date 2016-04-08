package com.svcet.cashportal.web.beans;

import java.util.ArrayList;
import java.util.List;

public class OrganizationRolesScreenRequest {

	private OrganizationReponse organization;

	private List<RoleRequest> assignedRoles = new ArrayList<RoleRequest>();

	public List<RoleRequest> getAssignedRoles() {
		return assignedRoles;
	}

	public void setAssignedRoles(List<RoleRequest> assignedRoles) {
		this.assignedRoles = assignedRoles;
	}

	public OrganizationReponse getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationReponse organization) {
		this.organization = organization;
	}
}

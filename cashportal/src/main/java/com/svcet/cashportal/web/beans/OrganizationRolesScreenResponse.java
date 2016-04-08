package com.svcet.cashportal.web.beans;

import java.util.ArrayList;
import java.util.List;

public class OrganizationRolesScreenResponse {

	private OrganizationReponse organization;

	private List<RoleResponse> availableRoles = new ArrayList<RoleResponse>();

	private List<RoleResponse> assignedRoles = new ArrayList<RoleResponse>();

	private List<RoleResponse> availableRolesToGrant = new ArrayList<RoleResponse>();

	private List<RoleResponse> assignedRolesToGrant = new ArrayList<RoleResponse>();

	public OrganizationReponse getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationReponse organization) {
		this.organization = organization;
	}

	public List<RoleResponse> getAvailableRoles() {
		return availableRoles;
	}

	public void setAvailableRoles(List<RoleResponse> availableRoles) {
		this.availableRoles = availableRoles;
	}

	public List<RoleResponse> getAssignedRoles() {
		return assignedRoles;
	}

	public void setAssignedRoles(List<RoleResponse> assignedRoles) {
		this.assignedRoles = assignedRoles;
	}

	public List<RoleResponse> getAvailableRolesToGrant() {
		return availableRolesToGrant;
	}

	public void setAvailableRolesToGrant(List<RoleResponse> availableRolesToGrant) {
		this.availableRolesToGrant = availableRolesToGrant;
	}

	public List<RoleResponse> getAssignedRolesToGrant() {
		return assignedRolesToGrant;
	}

	public void setAssignedRolesToGrant(List<RoleResponse> assignedRolesToGrant) {
		this.assignedRolesToGrant = assignedRolesToGrant;
	}

}

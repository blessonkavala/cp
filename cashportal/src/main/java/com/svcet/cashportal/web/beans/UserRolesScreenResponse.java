package com.svcet.cashportal.web.beans;

import java.util.ArrayList;
import java.util.List;

public class UserRolesScreenResponse {

	private UserResponse user;

	private List<RoleResponse> availableRoles = new ArrayList<RoleResponse>();

	private List<RoleResponse> assignedRoles = new ArrayList<RoleResponse>();

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

	public UserResponse getUser() {
		return user;
	}

	public void setUser(UserResponse user) {
		this.user = user;
	}
}

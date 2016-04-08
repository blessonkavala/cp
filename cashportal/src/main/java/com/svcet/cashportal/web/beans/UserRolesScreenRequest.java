package com.svcet.cashportal.web.beans;

import java.util.ArrayList;
import java.util.List;

public class UserRolesScreenRequest {

	private UserResponse user;

	private List<RoleRequest> assignedRoles = new ArrayList<RoleRequest>();

	public UserResponse getUser() {
		return user;
	}

	public void setUser(UserResponse user) {
		this.user = user;
	}

	public List<RoleRequest> getAssignedRoles() {
		return assignedRoles;
	}

	public void setAssignedRoles(List<RoleRequest> assignedRoles) {
		this.assignedRoles = assignedRoles;
	}
}

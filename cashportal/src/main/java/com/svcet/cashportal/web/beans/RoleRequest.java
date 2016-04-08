package com.svcet.cashportal.web.beans;

public class RoleRequest {
	private String rid;

	private String roleCode;
	private String roleDescription;
	private String roleDestination;

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getRoleDestination() {
		return roleDestination;
	}

	public void setRoleDestination(String roleDestination) {
		this.roleDestination = roleDestination;
	}
}

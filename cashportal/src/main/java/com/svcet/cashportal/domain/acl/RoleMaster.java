package com.svcet.cashportal.domain.acl;

import com.svcet.cashportal.domain.BaseEntity;

/**
 * 
 * 
 *
 */
public class RoleMaster extends BaseEntity {

	private String roleCode;
	private String roleDescription;
	private String roleDestination;

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

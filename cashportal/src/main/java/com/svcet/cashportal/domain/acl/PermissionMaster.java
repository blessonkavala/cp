package com.svcet.cashportal.domain.acl;

import com.svcet.cashportal.domain.BaseEntity;

public class PermissionMaster extends BaseEntity {
	private String permissionCode;
	private String permissionDescription;
	private String permissionDestination;

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public String getPermissionDescription() {
		return permissionDescription;
	}

	public void setPermissionDescription(String permissionDescription) {
		this.permissionDescription = permissionDescription;
	}

	public String getPermissionDestination() {
		return permissionDestination;
	}

	public void setPermissionDestination(String permissionDestination) {
		this.permissionDestination = permissionDestination;
	}

}

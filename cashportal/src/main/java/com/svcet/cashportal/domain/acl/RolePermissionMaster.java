package com.svcet.cashportal.domain.acl;

import com.svcet.cashportal.domain.BaseEntity;

public class RolePermissionMaster extends BaseEntity {

	private RoleMaster roleId;

	private PermissionMaster permissionId;

	public RoleMaster getRoleId() {
		return roleId;
	}

	public void setRoleId(RoleMaster roleId) {
		this.roleId = roleId;
	}

	public PermissionMaster getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(PermissionMaster permissionId) {
		this.permissionId = permissionId;
	}

}

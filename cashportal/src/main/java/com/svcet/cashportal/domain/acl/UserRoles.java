package com.svcet.cashportal.domain.acl;

import com.svcet.cashportal.domain.BaseEntity;
import com.svcet.cashportal.domain.UserMaster;

public class UserRoles extends BaseEntity {

	private UserMaster userId;

	private RoleMaster roleId;

	public UserMaster getUserId() {
		return userId;
	}

	public void setUserId(UserMaster userId) {
		this.userId = userId;
	}

	public RoleMaster getRoleId() {
		return roleId;
	}

	public void setRoleId(RoleMaster roleId) {
		this.roleId = roleId;
	}

}

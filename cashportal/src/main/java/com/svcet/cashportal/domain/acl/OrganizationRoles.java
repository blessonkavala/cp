package com.svcet.cashportal.domain.acl;

import com.svcet.cashportal.domain.BaseEntity;
import com.svcet.cashportal.domain.OrganizationMaster;

public class OrganizationRoles extends BaseEntity {

	private OrganizationMaster orgId;

	private RoleMaster roleId;

	public OrganizationMaster getOrgId() {
		return orgId;
	}

	public void setOrgId(OrganizationMaster orgId) {
		this.orgId = orgId;
	}

	public RoleMaster getRoleId() {
		return roleId;
	}

	public void setRoleId(RoleMaster roleId) {
		this.roleId = roleId;
	}

}

package com.svcet.cashportal.domain;

import javax.persistence.ManyToOne;

public class UserMaster extends BaseEntity {

	private String userName;

	private String password;

	@ManyToOne
	private OrganizationMaster orgId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public OrganizationMaster getOrgId() {
		return orgId;
	}

	public void setOrgId(OrganizationMaster orgId) {
		this.orgId = orgId;
	}
}

package com.svcet.cashportal.domain;

public class CustomerAccount extends BaseEntity {

	private Account account;

	private OrganizationMaster customerOrgId;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public OrganizationMaster getCustomerOrgId() {
		return customerOrgId;
	}

	public void setCustomerOrgId(OrganizationMaster customerOrgId) {
		this.customerOrgId = customerOrgId;
	}
}

package com.svcet.cashportal.web.beans;

public class CustomerAccountRequest {

	private AccountRequest accountRequest;

	private String customerOrgId;

	public AccountRequest getAccountRequest() {
		return accountRequest;
	}

	public void setAccountRequest(AccountRequest accountRequest) {
		this.accountRequest = accountRequest;
	}

	public String getCustomerOrgId() {
		return customerOrgId;
	}

	public void setCustomerOrgId(String customerOrgId) {
		this.customerOrgId = customerOrgId;
	}
}

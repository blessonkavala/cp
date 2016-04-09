package com.svcet.cashportal.web.beans;

public class CustomerAccountResponse {

	private AccountResponse accountResponse;

	private String customerOrgId;

	public AccountResponse getAccountResponse() {
		return accountResponse;
	}

	public void setAccountResponse(AccountResponse accountResponse) {
		this.accountResponse = accountResponse;
	}

	public String getCustomerOrgId() {
		return customerOrgId;
	}

	public void setCustomerOrgId(String customerOrgId) {
		this.customerOrgId = customerOrgId;
	}
}

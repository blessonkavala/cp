package com.svcet.cashportal.web.beans;

public class CustomerAccountResponse {

	private String rid;

	private AccountResponse account;

	private String customerOrgId;

	public String getCustomerOrgId() {
		return customerOrgId;
	}

	public void setCustomerOrgId(String customerOrgId) {
		this.customerOrgId = customerOrgId;
	}

	public AccountResponse getAccount() {
		return account;
	}

	public void setAccount(AccountResponse account) {
		this.account = account;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}
}

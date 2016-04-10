package com.svcet.cashportal.web.beans;

public class CustomerAccountRequest {

	private String rid;

	private AccountRequest account;

	private String customerOrgId;

	public String getCustomerOrgId() {
		return customerOrgId;
	}

	public void setCustomerOrgId(String customerOrgId) {
		this.customerOrgId = customerOrgId;
	}

	public AccountRequest getAccount() {
		return account;
	}

	public void setAccount(AccountRequest account) {
		this.account = account;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}
}

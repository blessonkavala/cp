package com.svcet.cashportal.domain;

public class UserAccount extends BaseEntity {

	private Account account;

	private UserMaster userId;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public UserMaster getUserId() {
		return userId;
	}

	public void setUserId(UserMaster userId) {
		this.userId = userId;
	}

}

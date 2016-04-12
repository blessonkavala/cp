package com.svcet.cashportal.web.beans;

import java.util.ArrayList;
import java.util.List;

public class UserAccountsScreenRequest {

	private String userId;

	private List<UserAccountResponse> userAccounts = new ArrayList<UserAccountResponse>();

	public List<UserAccountResponse> getUserAccounts() {
		return userAccounts;
	}

	public void setUserAccounts(List<UserAccountResponse> userAccounts) {
		this.userAccounts = userAccounts;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}

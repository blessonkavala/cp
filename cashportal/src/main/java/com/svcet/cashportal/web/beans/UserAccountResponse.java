package com.svcet.cashportal.web.beans;

import com.svcet.cashportal.domain.UserAccount;

public class UserAccountResponse {

	private boolean selected;

	private UserAccount userAccount;

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}

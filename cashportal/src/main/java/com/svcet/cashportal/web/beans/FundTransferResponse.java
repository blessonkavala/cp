package com.svcet.cashportal.web.beans;

import java.util.ArrayList;
import java.util.List;

import com.svcet.cashportal.domain.UserAccount;
import com.svcet.cashportal.domain.product.ft.FundTransfer;

public class FundTransferResponse {

	private boolean bankUser = false;

	private boolean customerUser = false;

	private FundTransfer fundTransfer;

	List<UserAccount> userAccounts = new ArrayList<UserAccount>();

	public FundTransfer getFundTransfer() {
		return fundTransfer;
	}

	public void setFundTransfer(FundTransfer fundTransfer) {
		this.fundTransfer = fundTransfer;
	}

	public List<UserAccount> getUserAccounts() {
		return userAccounts;
	}

	public void setUserAccounts(List<UserAccount> userAccounts) {
		this.userAccounts = userAccounts;
	}

	public boolean isCustomerUser() {
		return customerUser;
	}

	public void setCustomerUser(boolean customerUser) {
		this.customerUser = customerUser;
	}

	public boolean isBankUser() {
		return bankUser;
	}

	public void setBankUser(boolean bankUser) {
		this.bankUser = bankUser;
	}

}

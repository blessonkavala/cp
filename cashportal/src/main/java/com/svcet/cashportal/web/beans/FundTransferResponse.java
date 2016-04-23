package com.svcet.cashportal.web.beans;

import java.util.ArrayList;
import java.util.List;

import com.svcet.cashportal.domain.UserAccount;
import com.svcet.cashportal.domain.product.ft.FundTransfer;

public class FundTransferResponse {

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

}

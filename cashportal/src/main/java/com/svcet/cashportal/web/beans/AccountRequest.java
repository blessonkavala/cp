package com.svcet.cashportal.web.beans;

public class AccountRequest {
	private String rid;
	private String accountNo;
	private String description;
	private String accountType;
	private String curCode;
	private String branchNo;
	private String overdraftLimit;
	private String interestRate;
	private String interestRateCredit;
	private String interestRateDebit;
	private String active;

	private String bankOrgId;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCurCode() {
		return curCode;
	}

	public void setCurCode(String curCode) {
		this.curCode = curCode;
	}

	public String getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}

	public String getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(String overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	public String getInterestRateCredit() {
		return interestRateCredit;
	}

	public void setInterestRateCredit(String interestRateCredit) {
		this.interestRateCredit = interestRateCredit;
	}

	public String getInterestRateDebit() {
		return interestRateDebit;
	}

	public void setInterestRateDebit(String interestRateDebit) {
		this.interestRateDebit = interestRateDebit;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getBankOrgId() {
		return bankOrgId;
	}

	public void setBankOrgId(String bankOrgId) {
		this.bankOrgId = bankOrgId;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}
}

package com.svcet.cashportal.service;

import java.util.List;

import com.svcet.cashportal.web.beans.AccountRequest;
import com.svcet.cashportal.web.beans.AccountResponse;
import com.svcet.cashportal.web.beans.CustomerAccountRequest;
import com.svcet.cashportal.web.beans.CustomerAccountResponse;

public interface AccountService {
	public AccountResponse save(AccountRequest accountRequest);

	public List<CustomerAccountResponse> findByCustomer(CustomerAccountRequest customerAccountRequest);
}

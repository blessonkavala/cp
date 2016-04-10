package com.svcet.cashportal.service;

import java.util.List;

import com.svcet.cashportal.web.beans.CustomerAccountRequest;
import com.svcet.cashportal.web.beans.CustomerAccountResponse;

public interface AccountService {
	public CustomerAccountResponse save(CustomerAccountRequest customerAccountRequest);

	public List<CustomerAccountResponse> findByCustomer(CustomerAccountRequest customerAccountRequest);

	public CustomerAccountResponse findById(String rid);
}

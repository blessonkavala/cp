package com.svcet.cashportal.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.svcet.cashportal.service.AccountService;
import com.svcet.cashportal.web.beans.AccountRequest;
import com.svcet.cashportal.web.beans.AccountResponse;
import com.svcet.cashportal.web.beans.CustomerAccountRequest;
import com.svcet.cashportal.web.beans.CustomerAccountResponse;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.POST, value = "/account/save")
	@ResponseBody
	public AccountResponse save(@RequestBody AccountRequest accountRequest) {
		return accountService.save(accountRequest);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/customeraccount/list")
	@ResponseBody
	public CustomerAccountResponse[] findAll(@RequestBody CustomerAccountRequest customerAccountRequest) {
		List<CustomerAccountResponse> customerAccountResponseList = accountService
				.findByCustomer(customerAccountRequest);
		return customerAccountResponseList.toArray(new CustomerAccountResponse[customerAccountResponseList.size()]);
	}
}

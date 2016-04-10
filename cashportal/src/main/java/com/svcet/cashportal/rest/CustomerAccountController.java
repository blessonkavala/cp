package com.svcet.cashportal.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.svcet.cashportal.service.AccountService;
import com.svcet.cashportal.web.beans.CustomerAccountRequest;
import com.svcet.cashportal.web.beans.CustomerAccountResponse;

@RestController
public class CustomerAccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.POST, value = "/customeraccount/save")
	@ResponseBody
	public CustomerAccountResponse save(@RequestBody CustomerAccountRequest customerAccountRequest) {
		return accountService.save(customerAccountRequest);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/customeraccount/update")
	public CustomerAccountResponse update(@RequestBody CustomerAccountRequest customerAccountRequest) {
		 return accountService.save(customerAccountRequest);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/customeraccount/list")
	@ResponseBody
	public CustomerAccountResponse[] findAll(@RequestBody CustomerAccountRequest customerAccountRequest) {
		List<CustomerAccountResponse> customerAccountResponseList = accountService
				.findByCustomer(customerAccountRequest);
		return customerAccountResponseList.toArray(new CustomerAccountResponse[customerAccountResponseList.size()]);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/customeraccount/query")
	public CustomerAccountResponse findOne(@RequestBody CustomerAccountRequest customerAccountRequest) {
		return accountService.findById(customerAccountRequest.getRid());
	}

}

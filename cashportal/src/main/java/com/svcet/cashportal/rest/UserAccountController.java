package com.svcet.cashportal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.svcet.cashportal.service.UserAccountService;
import com.svcet.cashportal.web.beans.UserAccountsScreenRequest;
import com.svcet.cashportal.web.beans.UserAccountsScreenResponse;
import com.svcet.cashportal.web.beans.UserRequest;

@RestController
public class UserAccountController {

	@Autowired
	private UserAccountService userAccountService;

	@RequestMapping(method = RequestMethod.POST, value = "/useraccounts/query")
	public UserAccountsScreenResponse edit(@RequestBody UserRequest userRequest) {
		return userAccountService.editUserAccounts(userRequest);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/useraccounts/update")
	public void update(@RequestBody UserAccountsScreenRequest userAccountsScreenRequest) {
		userAccountService.updateUserAccounts(userAccountsScreenRequest);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/useraccounts/view")
	public UserAccountsScreenResponse view(@RequestBody UserRequest userRequest) {
		return userAccountService.findAll(userRequest);
	}

}

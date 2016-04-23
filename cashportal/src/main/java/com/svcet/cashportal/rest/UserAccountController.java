package com.svcet.cashportal.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.svcet.cashportal.domain.UserAccount;
import com.svcet.cashportal.domain.UserMaster;
import com.svcet.cashportal.repository.UserAccountRepository;
import com.svcet.cashportal.service.UserAccountService;
import com.svcet.cashportal.utils.OrganizationUtils;
import com.svcet.cashportal.web.beans.UserAccountsScreenRequest;
import com.svcet.cashportal.web.beans.UserAccountsScreenResponse;
import com.svcet.cashportal.web.beans.UserRequest;

@RestController
public class UserAccountController {

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private OrganizationUtils organizationUtils;

	@Autowired
	private UserAccountRepository userAccountRepository;

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

	@RequestMapping(method = RequestMethod.GET, value = "/loggeduseraccounts/list")
	public List<UserAccount> loggedUserAccounts() {
		UserMaster userMaster = organizationUtils.getLoggedInUser();
		return userAccountRepository.findByUserId(userMaster.getRid());
	}

}

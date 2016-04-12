package com.svcet.cashportal.service;

import com.svcet.cashportal.web.beans.UserAccountsScreenRequest;
import com.svcet.cashportal.web.beans.UserAccountsScreenResponse;
import com.svcet.cashportal.web.beans.UserRequest;

public interface UserAccountService {

	UserAccountsScreenResponse editUserAccounts(UserRequest userRequest);

	void updateUserAccounts(UserAccountsScreenRequest userAccountsScreenRequest);

	UserAccountsScreenResponse findAll(UserRequest userRequest);

}

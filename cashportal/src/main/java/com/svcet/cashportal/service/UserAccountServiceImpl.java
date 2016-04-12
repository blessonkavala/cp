package com.svcet.cashportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svcet.cashportal.domain.CustomerAccount;
import com.svcet.cashportal.domain.UserAccount;
import com.svcet.cashportal.domain.UserMaster;
import com.svcet.cashportal.repository.AccountRepository;
import com.svcet.cashportal.repository.CustomerAccountRepository;
import com.svcet.cashportal.repository.UserAccountRepository;
import com.svcet.cashportal.repository.UserRepository;
import com.svcet.cashportal.web.beans.UserAccountResponse;
import com.svcet.cashportal.web.beans.UserAccountsScreenRequest;
import com.svcet.cashportal.web.beans.UserAccountsScreenResponse;
import com.svcet.cashportal.web.beans.UserRequest;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomerAccountRepository customerAccountRepository;

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserAccountsScreenResponse editUserAccounts(UserRequest userRequest) {
		UserAccountsScreenResponse userAccountsScreenResponse = new UserAccountsScreenResponse();
		UserMaster userMaster = userRepository.findByRid(userRequest.getRid());
		userAccountsScreenResponse.setUserId(userMaster.getRid());
		// FETCH ALL CUSTOMER ACCOUNTS
		List<CustomerAccount> customerAccountList = customerAccountRepository
				.findByCustomerOrgId(userMaster.getOrgId().getRid());
		userAccountsScreenResponse.setCustomerOrgId(userMaster.getOrgId().getRid());
		// FETCH ALL EXISTING USRER ACCOUNTS
		List<UserAccount> assignedUserAccountList = userAccountRepository.findByUserId(userMaster.getRid());
		List<String> assignedAccountIdsList = new ArrayList<String>();
		for (UserAccount userAccount : assignedUserAccountList) {
			assignedAccountIdsList.add(userAccount.getAccount().getRid());
		}
		for (CustomerAccount customerAccount : customerAccountList) {
			UserAccountResponse userAccountResponse = new UserAccountResponse();
			UserAccount userAccount = new UserAccount();
			userAccount.setUserId(userMaster);
			userAccount.setAccount(customerAccount.getAccount());
			userAccountResponse.setUserAccount(userAccount);
			if (assignedAccountIdsList.contains(customerAccount.getAccount().getRid())) {
				userAccountResponse.setSelected(true);
			} else {
				userAccountResponse.setSelected(false);
			}
			userAccountsScreenResponse.getUserAccounts().add(userAccountResponse);
		}
		return userAccountsScreenResponse;
	}

	@Override
	public void updateUserAccounts(UserAccountsScreenRequest userAccountsScreenRequest) {

		List<UserAccountResponse> userAccountResponseList = userAccountsScreenRequest.getUserAccounts();
		UserMaster userMaster = userRepository.findByRid(userAccountsScreenRequest.getUserId());
		List<UserAccount> selectedUserAccountList = new ArrayList<UserAccount>();
		for (UserAccountResponse userAccountResponse : userAccountResponseList) {
			if (userAccountResponse.isSelected()) {
				UserAccount userAccount = new UserAccount();
				userAccount.setAccount(
						accountRepository.findByRid(userAccountResponse.getUserAccount().getAccount().getRid()));

				userAccount.setUserId(userMaster);
				selectedUserAccountList.add(userAccount);
			}
		}
		// FETCH ALL EXISTING USRER ACCOUNTS
		List<UserAccount> assignedUserAccountList = userAccountRepository.findByUserId(userMaster.getRid());
		userAccountRepository.delete(assignedUserAccountList);
		for (UserAccount userAccount : selectedUserAccountList) {
			userAccountRepository.save(userAccount);
		}
	}

	@Override
	public UserAccountsScreenResponse findAll(UserRequest userRequest) {
		UserAccountsScreenResponse userAccountsScreenResponse = new UserAccountsScreenResponse();
		UserMaster userMaster = userRepository.findByRid(userRequest.getRid());
		List<UserAccount> userAccounts = userAccountRepository.findByUserId(userMaster.getRid());
		for (UserAccount userAccount : userAccounts) {
			UserAccountResponse userAccountResponse = new UserAccountResponse();
			userAccountResponse.setUserAccount(userAccount);
			userAccountResponse.setSelected(true);
			userAccountsScreenResponse.getUserAccounts().add(userAccountResponse);
		}
		return userAccountsScreenResponse;
	}
}

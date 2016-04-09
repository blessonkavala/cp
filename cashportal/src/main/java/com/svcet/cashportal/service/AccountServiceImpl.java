package com.svcet.cashportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svcet.cashportal.domain.Account;
import com.svcet.cashportal.domain.CustomerAccount;
import com.svcet.cashportal.domain.OrganizationMaster;
import com.svcet.cashportal.exception.DuplicateAccountException;
import com.svcet.cashportal.repository.AccountRepository;
import com.svcet.cashportal.repository.CustomerAccountRepository;
import com.svcet.cashportal.repository.OrganizationRepository;
import com.svcet.cashportal.web.beans.AccountRequest;
import com.svcet.cashportal.web.beans.AccountResponse;
import com.svcet.cashportal.web.beans.CustomerAccountRequest;
import com.svcet.cashportal.web.beans.CustomerAccountResponse;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomerAccountRepository customerAccountRepository;

	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public AccountResponse save(AccountRequest accountRequest) {
		// CHECK IF THIS ACCOUNT NUMBER ALREADY EXISTS FOR THIS BANK
		String accountNumber = accountRequest.getAccountNo();
		String bankOrgId = accountRequest.getBankOrgId();
		try {
			accountRepository.findByAccountNoAndBankOrgId(accountNumber, bankOrgId);
			throw new DuplicateAccountException();
		} catch (IndexOutOfBoundsException e) {
			// CONVERT AccountRequest object to domain model bean Account
			Account account = new Account();
			BeanUtils.copyProperties(accountRequest, account, "bankOrgId");
			// Fetch bankOrgId OrganizationMaster reference
			OrganizationMaster bank = organizationRepository.findByRid(bankOrgId);
			account.setBankOrgId(bank);
			account = accountRepository.save(account);
			//
			AccountResponse accountResponse = new AccountResponse();
			BeanUtils.copyProperties(account, accountResponse, "bankOrgId");
			accountResponse.setBankOrgId(bank.getRid());
			return accountResponse;
		}
	}

	@Override
	public List<CustomerAccountResponse> findByCustomer(CustomerAccountRequest customerAccountRequest) {
		List<CustomerAccountResponse> customerAccountResponseList = new ArrayList<CustomerAccountResponse>();
		List<CustomerAccount> customerAccountList = customerAccountRepository
				.findByCustomerOrgId(customerAccountRequest.getCustomerOrgId());
		for (CustomerAccount customerAccount : customerAccountList) {
			CustomerAccountResponse customerAccountResponse = new CustomerAccountResponse();
			AccountResponse accountResponse = new AccountResponse();
			BeanUtils.copyProperties(customerAccount.getAccount(), accountResponse);
			customerAccountResponse.setAccountResponse(accountResponse);
			customerAccountResponse.setCustomerOrgId(customerAccount.getCustomerOrgId().getRid());
			customerAccountResponseList.add(customerAccountResponse);
		}
		return customerAccountResponseList;
	}
}

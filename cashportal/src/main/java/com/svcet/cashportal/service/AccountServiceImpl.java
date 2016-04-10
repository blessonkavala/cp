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
	public CustomerAccountResponse save(CustomerAccountRequest customerAccountRequest) {
		String accountNumber = customerAccountRequest.getAccount().getAccountNo();
		String customerOrgId = customerAccountRequest.getCustomerOrgId();
		OrganizationMaster customerOrgMaster = organizationRepository.findByRid(customerOrgId);
		try {
			// CHECK IF THIS ACCOUNT NUMBER ALREADY EXISTS FOR THE CUSTOMER BANK
			Account account = accountRepository.findByAccountNoAndBankOrgId(accountNumber,
					customerOrgMaster.getParentOrgId().getRid());
			if (!account.getRid().equals(customerAccountRequest.getAccount().getRid())) {
				throw new DuplicateAccountException();
			}
			throw new IndexOutOfBoundsException();
		} catch (IndexOutOfBoundsException e) {
			// Convert CustomerAccountRequest Object to domain model bean
			CustomerAccount customerAccount = new CustomerAccount();
			customerAccount.setRid(customerAccountRequest.getRid());
			customerAccount.setCustomerOrgId(customerOrgMaster);
			// CONVERT AccountRequest object to domain model bean Account
			Account account = new Account();
			BeanUtils.copyProperties(customerAccountRequest.getAccount(), account, "bankOrgId");
			// Fetch bankOrgId OrganizationMaster reference
			account.setBankOrgId(customerOrgMaster.getParentOrgId());
			customerAccount.setAccount(account);
			customerAccount = customerAccountRepository.save(customerAccount);
			//
			CustomerAccountResponse customerAccountResponse = new CustomerAccountResponse();
			customerAccountResponse.setRid(customerAccount.getRid());
			customerAccountResponse.setCustomerOrgId(customerOrgId);
			AccountResponse accountResponse = new AccountResponse();
			BeanUtils.copyProperties(customerAccount.getAccount(), accountResponse, "bankOrgId");
			accountResponse.setBankOrgId(customerOrgMaster.getParentOrgId().getRid());
			customerAccountResponse.setAccount(accountResponse);
			return customerAccountResponse;
		}
	}

	@Override
	public List<CustomerAccountResponse> findByCustomer(CustomerAccountRequest customerAccountRequest) {
		List<CustomerAccountResponse> customerAccountResponseList = new ArrayList<CustomerAccountResponse>();
		List<CustomerAccount> customerAccountList = customerAccountRepository
				.findByCustomerOrgId(customerAccountRequest.getCustomerOrgId());
		for (CustomerAccount customerAccount : customerAccountList) {
			CustomerAccountResponse customerAccountResponse = new CustomerAccountResponse();
			customerAccountResponse.setRid(customerAccount.getRid());
			AccountResponse accountResponse = new AccountResponse();
			BeanUtils.copyProperties(customerAccount.getAccount(), accountResponse);
			customerAccountResponse.setAccount(accountResponse);
			customerAccountResponse.setCustomerOrgId(customerAccount.getCustomerOrgId().getRid());
			customerAccountResponseList.add(customerAccountResponse);
		}
		return customerAccountResponseList;
	}

	@Override
	public CustomerAccountResponse findById(String rid) {
		CustomerAccount customerAccount = customerAccountRepository.findByRid(rid);
		CustomerAccountResponse customerAccountResponse = new CustomerAccountResponse();
		customerAccountResponse.setRid(customerAccount.getRid());
		AccountResponse accountResponse = new AccountResponse();
		BeanUtils.copyProperties(customerAccount.getAccount(), accountResponse);
		customerAccountResponse.setAccount(accountResponse);
		customerAccountResponse.setCustomerOrgId(customerAccount.getCustomerOrgId().getRid());
		return customerAccountResponse;
	}
}

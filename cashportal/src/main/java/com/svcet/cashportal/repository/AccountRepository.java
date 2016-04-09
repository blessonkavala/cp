package com.svcet.cashportal.repository;

import org.springframework.data.orient.commons.repository.annotation.Query;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

import com.svcet.cashportal.domain.Account;

public interface AccountRepository extends OrientObjectRepository<Account> {

	@Query("select from Account where accountNo  =  ? and bankOrgId.rid = ?")
	Account findByAccountNoAndBankOrgId(String accountNo, String bankOrgId);

}

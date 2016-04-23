package com.svcet.cashportal.repository;

import java.util.List;

import org.springframework.data.orient.commons.repository.annotation.Query;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

import com.svcet.cashportal.domain.CustomerAccount;

public interface CustomerAccountRepository extends OrientObjectRepository<CustomerAccount> {

	@Query("select from CustomerAccount where @rid = ?")
	CustomerAccount findByRid(String rid);
	
	@Query("select from CustomerAccount where customerOrgId = ? and account.accountNo = ?")
	CustomerAccount findByCustomerAndAccountNo(String customerId,String accountNo);
	
	@Query("select from CustomerAccount where customerOrgId= ?")
	List<CustomerAccount> findByCustomerOrgId(String customerOrgid);

}

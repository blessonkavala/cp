package com.svcet.cashportal.repository;

import java.util.List;

import org.springframework.data.orient.commons.repository.annotation.Query;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

import com.svcet.cashportal.domain.UserAccount;

public interface UserAccountRepository extends OrientObjectRepository<UserAccount> {

	@Query("select from UserAccount where userId.rid = ?")
	List<UserAccount> findByUserId(String userId);

}

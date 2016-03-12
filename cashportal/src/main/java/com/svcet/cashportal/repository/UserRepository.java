package com.svcet.cashportal.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.svcet.cashportal.domain.UserMaster;

public interface UserRepository extends PagingAndSortingRepository<UserMaster, Long> {
	UserMaster findOneByUserNameAndPasswordAndOrgId(String username, String password, String orgId);
}

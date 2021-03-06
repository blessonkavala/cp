package com.svcet.cashportal.repository;

import org.springframework.data.orient.commons.repository.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.svcet.cashportal.domain.UserMaster;
import com.svcet.cashportal.domain.OrganizationMaster;
import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<UserMaster, Long> {
	UserMaster findOneByUserNameAndPasswordAndOrgId(String username, String password, String orgId);

	UserMaster findOneByUserNameAndOrgId(String userName, String orgId);

	@Query("select from UserMaster where @rid = ?")
	UserMaster findByRid(String id);

	List<UserMaster> findByOrgId(String orgid);
}

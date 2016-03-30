package com.svcet.cashportal.repository.acl;

import org.springframework.data.orient.commons.repository.annotation.Query;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

import com.svcet.cashportal.domain.acl.UserRoles;
import com.svcet.cashportal.domain.UserMaster;
import java.util.List;

public interface UserRolesRepository extends OrientObjectRepository<UserRoles> {

	@Query("select from UserRoles where userId.@rid = ?")
	List<UserRoles> findByUserId(String userId);
}

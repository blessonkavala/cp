package com.svcet.cashportal.repository;

import org.springframework.data.orient.object.repository.OrientObjectRepository;

import com.svcet.cashportal.domain.acl.RoleMaster;

public interface RoleMasterRepository extends OrientObjectRepository<RoleMaster> {
	RoleMaster findByRoleCode(String rolecode);
}

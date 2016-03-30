package com.svcet.cashportal.repository.acl;

import java.util.List;

import org.springframework.data.orient.commons.repository.annotation.Query;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

import com.svcet.cashportal.domain.acl.RolePermissionMaster;

public interface RolePermissionMasterRepository extends OrientObjectRepository<RolePermissionMaster> {

	@Query("select from RolePermissionMaster where roleId.@rid = ?")
	List<RolePermissionMaster> findByRoleId(String roleid);

}

package com.svcet.cashportal.repository;

import java.util.List;

import org.springframework.data.orient.commons.repository.annotation.Query;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

import com.svcet.cashportal.domain.acl.OrganizationRoles;

public interface OrganizationRoleRepository extends OrientObjectRepository<OrganizationRoles> {
	
	@Query("select from OrganizationRoles where orgId = ?")
	List<OrganizationRoles> findByOrgId(String orgid);

	@Query("select from OrganizationRoles where orgId = ? and roleId.roleDestination = ? ")
	List<OrganizationRoles> findByOrgIdAndRoleDest(String parentOrgId, String orgType);
	
	/*@Query("delete from OrganizationRoles where orgId = ?")
	OrganizationRoles deleteByOrgIdAndRoleDest(String orgId);*/
	
}

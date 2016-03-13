package com.svcet.cashportal.repository;

import org.springframework.data.orient.commons.repository.annotation.Query;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

import com.svcet.cashportal.domain.OrganizationMaster;

public interface OrganizationRepository extends OrientObjectRepository<OrganizationMaster> {

	OrganizationMaster findByOrgName(String orgname);
	
	@Query("select from OrganizationMaster where @rid = ?")
	OrganizationMaster findByRid(String rid);
}

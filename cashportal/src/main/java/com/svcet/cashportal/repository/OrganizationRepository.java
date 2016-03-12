package com.svcet.cashportal.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.svcet.cashportal.domain.OrganizationMaster;

public interface OrganizationRepository extends PagingAndSortingRepository<OrganizationMaster, Long> {

	OrganizationMaster findByOrgName(String orgname);
}

package com.svcet.cashportal.service;

import java.util.List;

import com.svcet.cashportal.domain.OrganizationMaster;
import com.svcet.cashportal.web.beans.OrganizationReponse;
import com.svcet.cashportal.web.beans.OrganizationRequest;

public interface OraganizationService {

	OrganizationMaster save(OrganizationRequest organizationRequest);

	OrganizationReponse findById(String organizationId);

	OrganizationMaster findByOrgName(String organizationName);

	OrganizationReponse update(OrganizationRequest organizationRequest);

	List<OrganizationReponse> findAll(String orgType);

}

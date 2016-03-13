package com.svcet.cashportal.service;

import com.svcet.cashportal.domain.OrganizationMaster;
import com.svcet.cashportal.web.beans.OrganizationReponse;
import com.svcet.cashportal.web.beans.OrganizationRequest;

public interface OraganizationService {
	
	OrganizationMaster save(OrganizationRequest organizationRequest);

	OrganizationReponse findById(String organizationId);

	OrganizationReponse update(OrganizationRequest organizationRequest);

}

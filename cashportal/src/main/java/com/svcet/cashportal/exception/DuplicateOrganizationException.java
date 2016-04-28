package com.svcet.cashportal.exception;

import com.svcet.cashportal.web.beans.OrganizationRequest;

public class DuplicateOrganizationException extends RuntimeException{
	
	private OrganizationRequest  organizationRequest;

	public OrganizationRequest getOrganizationRequest() {
		return organizationRequest;
	}

	public DuplicateOrganizationException(OrganizationRequest organizationRequest) {
		super();
		this.organizationRequest = organizationRequest;
	}
	
}

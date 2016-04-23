package com.svcet.cashportal.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.svcet.cashportal.domain.OrganizationMaster;
import com.svcet.cashportal.domain.UserMaster;
import com.svcet.cashportal.security.config.CashPortalExtendedPrincipal;
import com.svcet.cashportal.security.config.UserNamePasswordOrganizationAuthenticationToken;
import com.svcet.cashportal.service.OraganizationService;
import com.svcet.cashportal.service.UserService;

@Service
public class OrganizationUtils {

	@Autowired
	private UserService userService;

	@Autowired
	private OraganizationService oraganizationService;

	public static String getSubOrgType(String superOrgType) {
		String subOrgType = null;
		switch (superOrgType) {
		case "BANK_GROUP":
			subOrgType = "BANK";
			break;
		case "BANK":
			subOrgType = "CUSTOMER";
		}
		return subOrgType;
	}

	public String getLoggedInUserOrgType() {
		UserNamePasswordOrganizationAuthenticationToken authenticationToken = (UserNamePasswordOrganizationAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();
		final String orgName = authenticationToken.getOrganization();
		OrganizationMaster organizationMaster = oraganizationService.findByOrgName(orgName);
		return organizationMaster.getOrgType();
	}

	public OrganizationMaster getLoggedInUserOrg() {
		UserNamePasswordOrganizationAuthenticationToken authenticationToken = (UserNamePasswordOrganizationAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();
		final String orgName = authenticationToken.getOrganization();
		OrganizationMaster organizationMaster = oraganizationService.findByOrgName(orgName);
		return organizationMaster;
	}

	public UserMaster getLoggedInUser() {
		CashPortalExtendedPrincipal cashPortalExtendedPrincipal = (CashPortalExtendedPrincipal) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		UserNamePasswordOrganizationAuthenticationToken authenticationToken = (UserNamePasswordOrganizationAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();
		final String orgName = authenticationToken.getOrganization();
		OrganizationMaster organizationMaster = oraganizationService.findByOrgName(orgName);
		return userService.findOneByUserNameAndOrgId(cashPortalExtendedPrincipal.getUsername(),
				organizationMaster.getRid());
	}
}

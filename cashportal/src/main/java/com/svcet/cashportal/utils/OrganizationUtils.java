package com.svcet.cashportal.utils;

public class OrganizationUtils {
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
}

package com.svcet.cashportal.domain;

public class CountryMaster extends BaseEntity {

	private String countryCode;

	private String CountryFullName;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryFullName() {
		return CountryFullName;
	}

	public void setCountryFullName(String countryFullName) {
		CountryFullName = countryFullName;
	}
}

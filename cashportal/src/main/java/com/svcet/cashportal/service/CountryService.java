package com.svcet.cashportal.service;

import com.svcet.cashportal.domain.CountryMaster;

public interface CountryService {
	public CountryMaster findByCountryCode(String countryCode);
}

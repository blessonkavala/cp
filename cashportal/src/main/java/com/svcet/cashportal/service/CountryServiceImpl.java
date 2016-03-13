package com.svcet.cashportal.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.svcet.cashportal.domain.CountryMaster;
import com.svcet.cashportal.repository.CountryMasterRepository;

public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryMasterRepository countryMasterRepository;

	@Override
	public CountryMaster findByCountryCode(String countryCode) {
		return countryMasterRepository.findByCountryCode(countryCode);
	}

}

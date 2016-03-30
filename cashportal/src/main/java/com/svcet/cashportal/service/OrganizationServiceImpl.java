package com.svcet.cashportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svcet.cashportal.domain.CountryMaster;
import com.svcet.cashportal.domain.OrganizationMaster;
import com.svcet.cashportal.exception.DuplicateOrganizationException;
import com.svcet.cashportal.exception.OrganizationNotFoundException;
import com.svcet.cashportal.repository.CountryMasterRepository;
import com.svcet.cashportal.repository.OrganizationRepository;
import com.svcet.cashportal.web.beans.OrganizationReponse;
import com.svcet.cashportal.web.beans.OrganizationRequest;

@Service
public class OrganizationServiceImpl implements OraganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private CountryMasterRepository countryMasterRepository;

	@Override
	public OrganizationMaster save(OrganizationRequest organizationRequest) {
		try {
			// CHECK IF ANY ORGANIZATION EXISTS ALREADY WITH THE SAME NAME
			organizationRepository.findByOrgName(organizationRequest.getOrgName());
			throw new DuplicateOrganizationException();
		} catch (IndexOutOfBoundsException e) {
			// NO ORGANIZATION EXISTS WITH THIS NAME
			// TODO: VALIDATE BEAN
			OrganizationMaster organizationMaster = new OrganizationMaster();
			BeanUtils.copyProperties(organizationRequest, organizationMaster);
			// FETCH COUNTRY CODE
			CountryMaster countryId = countryMasterRepository.findByCountryCode(organizationRequest.getCountryCode());
			organizationMaster.setCountryId(countryId);
			CountryMaster legalCountryId = countryMasterRepository
					.findByCountryCode(organizationRequest.getLegalCountryCode());
			organizationMaster.setLegalCountryId(legalCountryId);
			return organizationRepository.save(organizationMaster);
		}
	}

	@Override
	public OrganizationReponse findById(String organizationId) {
		try {
			OrganizationMaster organizationMaster = organizationRepository.findByRid(organizationId);
			OrganizationReponse organizationReponse = new OrganizationReponse();
			BeanUtils.copyProperties(organizationMaster, organizationReponse);
			organizationReponse.setCountryCode(organizationMaster.getCountryId().getCountryCode());
			organizationReponse.setLegalCountryCode(organizationMaster.getLegalCountryId().getCountryCode());
			return organizationReponse;
		} catch (IndexOutOfBoundsException e) {
			throw new OrganizationNotFoundException();
		}
	}

	@Override
	public OrganizationReponse update(OrganizationRequest organizationRequest) {
		try {
			OrganizationMaster organizationMaster = organizationRepository.findByRid(organizationRequest.getRid());
			BeanUtils.copyProperties(organizationRequest, organizationMaster);
			// FETCH COUNTRY CODE
			CountryMaster countryId = countryMasterRepository.findByCountryCode(organizationRequest.getCountryCode());
			organizationMaster.setCountryId(countryId);
			CountryMaster legalCountryId = countryMasterRepository
					.findByCountryCode(organizationRequest.getLegalCountryCode());
			organizationMaster.setLegalCountryId(legalCountryId);
			organizationMaster = organizationRepository.save(organizationMaster);

			OrganizationReponse organizationReponse = new OrganizationReponse();
			BeanUtils.copyProperties(organizationMaster, organizationReponse);
			organizationReponse.setCountryCode(organizationMaster.getCountryId().getCountryCode());
			organizationReponse.setLegalCountryCode(organizationMaster.getLegalCountryId().getCountryCode());
			return organizationReponse;
		} catch (IndexOutOfBoundsException e) {
			throw new OrganizationNotFoundException();
		}
	}

	@Override
	public List<OrganizationReponse> findAll() {
		List<OrganizationReponse> organizationReponseList = new ArrayList<OrganizationReponse>();
		List<OrganizationMaster> organizationMasterList = organizationRepository.findAll();
		for (OrganizationMaster organizationMaster : organizationMasterList) {
			OrganizationReponse organizationReponse = new OrganizationReponse();
			BeanUtils.copyProperties(organizationMaster, organizationReponse);
			organizationReponse.setCountryCode(organizationMaster.getCountryId().getCountryCode());
			organizationReponse.setLegalCountryCode(organizationMaster.getLegalCountryId().getCountryCode());
			organizationReponseList.add(organizationReponse);
		}
		return organizationReponseList;
	}

	@Override
	public OrganizationMaster findByOrgName(String organizationName) {
		try {
			return organizationRepository.findByOrgName(organizationName);
		} catch (IndexOutOfBoundsException e) {
			throw new OrganizationNotFoundException();
		}
	}
}

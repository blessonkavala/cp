package com.svcet.cashportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svcet.cashportal.domain.OrganizationMaster;
import com.svcet.cashportal.domain.product.ft.FundTransfer;
import com.svcet.cashportal.repository.FundTransferRepository;
import com.svcet.cashportal.utils.OrganizationUtils;
import com.svcet.cashportal.web.beans.MOPendingRecordsRequest;
import com.svcet.cashportal.web.beans.MOPendingRecordsResponse;

@Service
public class MiddleOfficeServiceImpl implements MiddleOfficeService {

	@Autowired
	private FundTransferRepository fundTransferRepository;

	@Autowired
	private OrganizationUtils organizationUtils;

	@Override
	public MOPendingRecordsResponse list(MOPendingRecordsRequest moPendingRecordsRequest) {
		OrganizationMaster bankOrg = organizationUtils.getLoggedInUserOrg();
		MOPendingRecordsResponse moPendingRecordsResponse = new MOPendingRecordsResponse();
		List<FundTransfer> fundTransferList = fundTransferRepository.findByIssuingBankAndTnxStatCode(bankOrg.getRid(),
				moPendingRecordsRequest.getTnxStatCode());
		moPendingRecordsResponse.setFundTransferList(fundTransferList);
		return moPendingRecordsResponse;

	}
}

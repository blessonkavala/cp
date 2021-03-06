package com.svcet.cashportal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svcet.cashportal.domain.product.BusinessCodesProvider;
import com.svcet.cashportal.domain.product.ft.FundTransfer;
import com.svcet.cashportal.repository.CustomerAccountRepository;
import com.svcet.cashportal.repository.FundTransferRepository;
import com.svcet.cashportal.web.beans.FundTransferInquiryRequest;
import com.svcet.cashportal.web.beans.FundTransferInquiryResponse;
import com.svcet.cashportal.web.beans.FundTransferRequest;
import com.svcet.cashportal.web.beans.FundTransferResponse;

@Service
public class FundTransferServiceImpl implements FundTransferService {

	@Autowired
	private FundTransferRepository fundTransferRepository;

	@Override
	public FundTransferResponse save(FundTransferRequest fundTransferRequest) {

		FundTransfer fundTransfer = new FundTransfer();
		BeanUtils.copyProperties(fundTransferRequest.getFundTransfer(), fundTransfer);

		fundTransfer.setProductCode(BusinessCodesProvider.PRODUCT_FUNDTRANSFER_CODE);
		fundTransfer.setTnxStatCode(BusinessCodesProvider.TRANSACTION_STATUS_PENDING_APPROVAL);
		fundTransfer = fundTransferRepository.save(fundTransfer);

		FundTransferResponse fundTransferResponse = new FundTransferResponse();
		fundTransferResponse.setFundTransfer(fundTransfer);
		return fundTransferResponse;
	}
	
	@Override
	public FundTransferResponse update(FundTransfer fundTransfer) {
		fundTransfer.setTnxStatCode(BusinessCodesProvider.TRANSACTION_STATUS_RELEASED);
		fundTransfer = fundTransferRepository.save(fundTransfer);
		FundTransferResponse fundTransferResponse = new FundTransferResponse();
		fundTransferResponse.setFundTransfer(fundTransfer);
		return fundTransferResponse;
	}

	@Override
	public FundTransferInquiryResponse list(FundTransferInquiryRequest fundTransferInquiryRequest) {
		FundTransferInquiryResponse fundTransferInquiryResponse = new FundTransferInquiryResponse();
		List<FundTransfer> fundTransferList = fundTransferRepository
				.findByTnxStatCode(fundTransferInquiryRequest.getTnxStatCode());
		fundTransferInquiryResponse.setFundTransferList(fundTransferList);
		return fundTransferInquiryResponse;
	}

	@Override
	public FundTransferResponse findById(String rid) {
		FundTransferResponse fundTransferResponse = new FundTransferResponse();
		FundTransfer fundTransfer = fundTransferRepository.findByRid(rid);
		fundTransferResponse.setFundTransfer(fundTransfer);
		return fundTransferResponse;
	}

}

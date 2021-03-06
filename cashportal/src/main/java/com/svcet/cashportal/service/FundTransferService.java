package com.svcet.cashportal.service;

import com.svcet.cashportal.domain.product.ft.FundTransfer;
import com.svcet.cashportal.web.beans.FundTransferInquiryRequest;
import com.svcet.cashportal.web.beans.FundTransferInquiryResponse;
import com.svcet.cashportal.web.beans.FundTransferRequest;
import com.svcet.cashportal.web.beans.FundTransferResponse;

public interface FundTransferService {

	FundTransferResponse save(FundTransferRequest fundTransferRequest);

	FundTransferInquiryResponse list(FundTransferInquiryRequest fundTransferInquiryRequest);

	FundTransferResponse findById(String rid);

	FundTransferResponse update(FundTransfer fundTransfer);
}

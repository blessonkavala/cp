package com.svcet.cashportal.web.beans;

import java.util.ArrayList;
import java.util.List;

import com.svcet.cashportal.domain.product.ft.FundTransfer;

public class FundTransferInquiryResponse {

	List<FundTransfer> fundTransferList = new ArrayList<FundTransfer>();

	public List<FundTransfer> getFundTransferList() {
		return fundTransferList;
	}

	public void setFundTransferList(List<FundTransfer> fundTransferList) {
		this.fundTransferList = fundTransferList;
	};

}

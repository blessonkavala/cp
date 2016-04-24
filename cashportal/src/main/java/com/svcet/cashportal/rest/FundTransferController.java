package com.svcet.cashportal.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.svcet.cashportal.domain.CustomerAccount;
import com.svcet.cashportal.domain.OrganizationMaster;
import com.svcet.cashportal.domain.UserMaster;
import com.svcet.cashportal.domain.product.ft.FundTransfer;
import com.svcet.cashportal.repository.CustomerAccountRepository;
import com.svcet.cashportal.repository.UserAccountRepository;
import com.svcet.cashportal.service.FundTransferService;
import com.svcet.cashportal.utils.OrganizationUtils;
import com.svcet.cashportal.web.beans.FundTransferInquiryRequest;
import com.svcet.cashportal.web.beans.FundTransferInquiryResponse;
import com.svcet.cashportal.web.beans.FundTransferRequest;
import com.svcet.cashportal.web.beans.FundTransferResponse;

@RestController
public class FundTransferController {

	@Autowired
	private FundTransferService fundTransferService;

	@Autowired
	private OrganizationUtils organizationUtils;

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Autowired
	private CustomerAccountRepository customerAccountRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/ft/new")
	@ResponseBody
	public FundTransferResponse newFundTransfer() {
		FundTransferResponse fundTransferResponse = new FundTransferResponse();
		FundTransfer fundTransfer = new FundTransfer();
		// SET APPLICATION DATE AS CURRENT ATE
		fundTransfer.setApplicationDate(new Date());

		// SET ISSUING BANK AS CUSTOMERS BANK
		OrganizationMaster customerOrg = organizationUtils.getLoggedInUserOrg();
		fundTransfer.setIssuingBank(customerOrg.getParentOrgId());
		fundTransferResponse.setFundTransfer(fundTransfer);

		UserMaster userMaster = organizationUtils.getLoggedInUser();
		fundTransferResponse.setUserAccounts(userAccountRepository.findByUserId(userMaster.getRid()));
		return fundTransferResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/ft/save")
	@ResponseBody
	public FundTransferResponse save(@RequestBody FundTransferRequest fundTransferRequest) {
		OrganizationMaster customerOrg = organizationUtils.getLoggedInUserOrg();
		fundTransferRequest.getFundTransfer().setIssuingBank(customerOrg.getParentOrgId());
		fundTransferRequest.getFundTransfer().setInpUserId(organizationUtils.getLoggedInUser());

		fundTransferRequest.getFundTransfer().setApplicantAbbvName(customerOrg.getOrgName());
		fundTransferRequest.getFundTransfer().setApplicantAddressLine1(customerOrg.getAddressLine1());
		fundTransferRequest.getFundTransfer().setApplicantAddressLine2(customerOrg.getAddressLine2());
		fundTransferRequest.getFundTransfer().setApplicantCountry(customerOrg.getCountryId().getCountryCode());
		fundTransferRequest.getFundTransfer().setApplicantDom(customerOrg.getDom());
		fundTransferRequest.getFundTransfer().setApplicantName(customerOrg.getOrgName());
		fundTransferRequest.getFundTransfer().setApplicantReference(customerOrg.getCustomerReference());
		
		fundTransferRequest.getFundTransfer().setCompany(customerOrg);

		// Applicant Account
		CustomerAccount applicantCustomerAccount = customerAccountRepository.findByCustomerAndAccountNo(
				customerOrg.getRid(), fundTransferRequest.getFundTransfer().getApplicantActNo());

		fundTransferRequest.getFundTransfer()
				.setApplicantActCurCode(applicantCustomerAccount.getAccount().getCurCode());
		fundTransferRequest.getFundTransfer()
				.setApplicantActDescription(applicantCustomerAccount.getAccount().getDescription());
		fundTransferRequest.getFundTransfer().setFtCurCode(applicantCustomerAccount.getAccount().getCurCode());
		fundTransferRequest.getFundTransfer().setInpDttm(new Date());

		CustomerAccount beneficiaryCustomerAccount = customerAccountRepository.findByCustomerAndAccountNo(
				customerOrg.getRid(), fundTransferRequest.getFundTransfer().getCounterparty().getCounterpartyActNo());
		fundTransferRequest.getFundTransfer().getCounterparty()
				.setCounterpartyCurCode(beneficiaryCustomerAccount.getAccount().getCurCode());
		// TODO:
		fundTransferRequest.getFundTransfer().getCounterparty().setCounterpartyType("01");

		return fundTransferService.save(fundTransferRequest);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/ft/list")
	@ResponseBody
	public FundTransferInquiryResponse inquiry(@RequestBody FundTransferInquiryRequest fundTransferInquiryRequest) {
		return fundTransferService.list(fundTransferInquiryRequest);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/ft/query")
	public FundTransferResponse findOne(@RequestBody FundTransferInquiryRequest fundTransferInquiryRequest) {
		return fundTransferService.findById(fundTransferInquiryRequest.getRid());
	}

}

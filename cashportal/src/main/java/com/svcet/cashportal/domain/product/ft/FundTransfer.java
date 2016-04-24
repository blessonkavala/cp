package com.svcet.cashportal.domain.product.ft;

import java.util.Date;

import com.svcet.cashportal.domain.BaseEntity;
import com.svcet.cashportal.domain.OrganizationMaster;
import com.svcet.cashportal.domain.UserMaster;

public class FundTransfer extends BaseEntity {

	private String refId;
	private Date applicationDate;
	private String applicantAbbvName;

	private String applicantActName;
	private String applicantActNo;
	private String applicantActCurCode;
	private String applicantActDescription;

	private String applicantAddressLine1;
	private String applicantAddressLine2;
	private String applicantCountry;
	private String applicantDom;

	private String applicantName;
	private String applicantReference;

	private Date boInpDttm;
	private UserMaster boInpUserId;
	private String boRefId;
	private Date boReleaseDttm;
	private UserMaster boReleaseUserId;
	// COMPANY_NAME
	private OrganizationMaster company;

	private String ftAmt;
	private String ftCurCode;
	private String ftType;
	private Date inpDttm;
	private UserMaster inpUserId;
	private Date issDate;
	private String productCode;

	private String tnxStatCode;
	private String prodStatCode;

	private String remarks;

	private Counterparty counterparty;

	private OrganizationMaster issuingBank;

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getApplicantAbbvName() {
		return applicantAbbvName;
	}

	public void setApplicantAbbvName(String applicantAbbvName) {
		this.applicantAbbvName = applicantAbbvName;
	}

	public String getApplicantActName() {
		return applicantActName;
	}

	public void setApplicantActName(String applicantActName) {
		this.applicantActName = applicantActName;
	}

	public String getApplicantActNo() {
		return applicantActNo;
	}

	public void setApplicantActNo(String applicantActNo) {
		this.applicantActNo = applicantActNo;
	}

	public String getApplicantActCurCode() {
		return applicantActCurCode;
	}

	public void setApplicantActCurCode(String applicantActCurCode) {
		this.applicantActCurCode = applicantActCurCode;
	}

	public String getApplicantActDescription() {
		return applicantActDescription;
	}

	public void setApplicantActDescription(String applicantActDescription) {
		this.applicantActDescription = applicantActDescription;
	}

	public String getApplicantAddressLine1() {
		return applicantAddressLine1;
	}

	public void setApplicantAddressLine1(String applicantAddressLine1) {
		this.applicantAddressLine1 = applicantAddressLine1;
	}

	public String getApplicantAddressLine2() {
		return applicantAddressLine2;
	}

	public void setApplicantAddressLine2(String applicantAddressLine2) {
		this.applicantAddressLine2 = applicantAddressLine2;
	}

	public String getApplicantCountry() {
		return applicantCountry;
	}

	public void setApplicantCountry(String applicantCountry) {
		this.applicantCountry = applicantCountry;
	}

	public String getApplicantDom() {
		return applicantDom;
	}

	public void setApplicantDom(String applicantDom) {
		this.applicantDom = applicantDom;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantReference() {
		return applicantReference;
	}

	public void setApplicantReference(String applicantReference) {
		this.applicantReference = applicantReference;
	}

	public Date getBoInpDttm() {
		return boInpDttm;
	}

	public void setBoInpDttm(Date boInpDttm) {
		this.boInpDttm = boInpDttm;
	}

	public UserMaster getBoInpUserId() {
		return boInpUserId;
	}

	public void setBoInpUserId(UserMaster boInpUserId) {
		this.boInpUserId = boInpUserId;
	}

	public String getBoRefId() {
		return boRefId;
	}

	public void setBoRefId(String boRefId) {
		this.boRefId = boRefId;
	}

	public Date getBoReleaseDttm() {
		return boReleaseDttm;
	}

	public void setBoReleaseDttm(Date boReleaseDttm) {
		this.boReleaseDttm = boReleaseDttm;
	}

	public UserMaster getBoReleaseUserId() {
		return boReleaseUserId;
	}

	public void setBoReleaseUserId(UserMaster boReleaseUserId) {
		this.boReleaseUserId = boReleaseUserId;
	}

	public String getFtAmt() {
		return ftAmt;
	}

	public void setFtAmt(String ftAmt) {
		this.ftAmt = ftAmt;
	}

	public String getFtCurCode() {
		return ftCurCode;
	}

	public void setFtCurCode(String ftCurCode) {
		this.ftCurCode = ftCurCode;
	}

	public String getFtType() {
		return ftType;
	}

	public void setFtType(String ftType) {
		this.ftType = ftType;
	}

	public Date getInpDttm() {
		return inpDttm;
	}

	public void setInpDttm(Date inpDttm) {
		this.inpDttm = inpDttm;
	}

	public UserMaster getInpUserId() {
		return inpUserId;
	}

	public void setInpUserId(UserMaster inpUserId) {
		this.inpUserId = inpUserId;
	}

	public Date getIssDate() {
		return issDate;
	}

	public void setIssDate(Date issDate) {
		this.issDate = issDate;
	}

	public String getProdStatCode() {
		return prodStatCode;
	}

	public void setProdStatCode(String prodStatCode) {
		this.prodStatCode = prodStatCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Counterparty getCounterparty() {
		return counterparty;
	}

	public void setCounterparty(Counterparty counterparty) {
		this.counterparty = counterparty;
	}

	public String getTnxStatCode() {
		return tnxStatCode;
	}

	public void setTnxStatCode(String tnxStatCode) {
		this.tnxStatCode = tnxStatCode;
	}

	public OrganizationMaster getIssuingBank() {
		return issuingBank;
	}

	public void setIssuingBank(OrganizationMaster issuingBank) {
		this.issuingBank = issuingBank;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public OrganizationMaster getCompany() {
		return company;
	}

	public void setCompany(OrganizationMaster company) {
		this.company = company;
	}

}

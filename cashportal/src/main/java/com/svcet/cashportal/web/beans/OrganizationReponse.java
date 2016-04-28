package com.svcet.cashportal.web.beans;

import java.util.ArrayList;
import java.util.List;

public class OrganizationReponse {

	private ResponseState responseState;

	private List<ErrorModel> errors = new ArrayList<ErrorModel>();

	private String rid;

	private String orgName;
	private String addressLine1;
	private String addressLine2;
	private String street;
	private String dom;

	private String countryCode;

	private String status;
	private String legalIdType;
	private String legalIdNumber;

	private String legalCountryCode;

	private String contactName;
	private String contactNumber;
	private String fax;
	private String telex;
	private String bei;
	private String email;
	private String webAddress;
	private String customerReference;

	private String orgType;

	private String parentOrgId;

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLegalIdType() {
		return legalIdType;
	}

	public void setLegalIdType(String legalIdType) {
		this.legalIdType = legalIdType;
	}

	public String getLegalIdNumber() {
		return legalIdNumber;
	}

	public void setLegalIdNumber(String legalIdNumber) {
		this.legalIdNumber = legalIdNumber;
	}

	public String getLegalCountryCode() {
		return legalCountryCode;
	}

	public void setLegalCountryCode(String legalCountryCode) {
		this.legalCountryCode = legalCountryCode;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getTelex() {
		return telex;
	}

	public void setTelex(String telex) {
		this.telex = telex;
	}

	public String getBei() {
		return bei;
	}

	public void setBei(String bei) {
		this.bei = bei;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public String getCustomerReference() {
		return customerReference;
	}

	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getParentOrgId() {
		return parentOrgId;
	}

	public void setParentOrgId(String parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

	public ResponseState getResponseState() {
		return responseState;
	}

	public void setResponseState(ResponseState responseState) {
		this.responseState = responseState;
	}

	public List<ErrorModel> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorModel> errors) {
		this.errors = errors;
	}
}

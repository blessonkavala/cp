package com.svcet.cashportal.web.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserResponse {

	private ResponseState responseState;

	private List<ErrorModel> errors = new ArrayList<ErrorModel>();

	private String rid;

	private String userName;

	private String password;

	private String status;

	private String addressLine1;

	private String addressLine2;

	private String dom;

	private String countryId;

	private String email;

	private String fax;

	private String firstName;

	private String lastName;

	private Date lastLogin;

	private Date modifiedDttm;

	private String phone;

	private String orgId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getModifiedDttm() {
		return modifiedDttm;
	}

	public void setModifiedDttm(Date modifiedDttm) {
		this.modifiedDttm = modifiedDttm;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ResponseState getResopnseState() {
		return responseState;
	}

	public void setResopnseState(ResponseState resopnseState) {
		this.responseState = resopnseState;
	}

	public List<ErrorModel> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorModel> errors) {
		this.errors = errors;
	}

	public ResponseState getResponseState() {
		return responseState;
	}

	public void setResponseState(ResponseState responseState) {
		this.responseState = responseState;
	}

}

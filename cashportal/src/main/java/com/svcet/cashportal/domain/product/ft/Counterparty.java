package com.svcet.cashportal.domain.product.ft;

import com.svcet.cashportal.domain.BaseEntity;
import com.svcet.cashportal.domain.OrganizationMaster;

public class Counterparty extends BaseEntity {

	private String RefId;

	// COUNTERPARTY_ABBV_NAME
	// COUNTERPARTY_ACT_ISO_CODE
	private String counterpartyActNo;
	// COUNTERPARTY_ADDRESS_LINE_1
	// COUNTERPARTY_ADDRESS_LINE_2
	// COUNTERPARTY_AMT
	// COUNTERPARTY_COUNTRY
	private String counterpartyCurCode;
	// COUNTERPARTY_DOM
	// COUNTERPARTY_ISS_DATE
	// COUNTERPARTY_LABEL
	private String counterpartyName;
	// COUNTERPARTY_REFERENCE
	private String counterpartyType;

	// CPTY_BANK_SWIFT_BIC_CODE
	// CPTY_BANK_CODE
	// CPTY_BANK_NAME
	// CPTY_BANK_ADDRESS_LINE_1
	// CPTY_BANK_ADDRESS_LINE_2
	// CPTY_BANK_DOM
	// CPTY_BRANCH_CODE
	// CPTY_BRANCH_NAME
	// CPTY_BRANCH_ADDRESS_LINE_1
	/// CPTY_BRANCH_ADDRESS_LINE_2
	// CPTY_BRANCH_DOM
	// CPTY_BANK_COUNTRY
	// USUAL_ID
	// CPTY_INSTRUCTION_INDICATOR
	// CPTY_BENIF_INSTITUTION
	// CPTY_BENIF_ACCOUNT
	// CPTY_ACCOUNT_INSTITUTION
	// CPTY_BENIF_BANK_ROUTING_NO
	// CPTY_INTER_SWIFT_BIC_CODE
	// CPTY_INTER_BANK_NAME
	// CPTY_INTER_BANK_ADDR
	// CPTY_INTER_CITY_STATE
	// CPTY_INTER_COUNTRY
	// CPTY_INTER_ROUTING_NO
	// CPTY_SPECIAL_ROUTING_1
	// CPTY_SPECIAL_ROUTING_2
	// CPTY_SPECIAL_ROUTING_3
	// CPTY_SPECIAL_ROUTING_4
	// CPTY_SPECIAL_ROUTING_5
	// CPTY_SPECIAL_ROUTING_6
	// CPTY_PAYMENT_DETAIL_1
	// CPTY_PAYMENT_DETAIL_2
	// CPTY_PAYMENT_DETAIL_3
	// CPTY_PAYMENT_DETAIL_4
	// CPTY_ORDER_CUST_NAME
	// CPTY_ORDER_ACCOUNT_NO
	// CPTY_ORDER_CUST_ADDR
	// CPTY_ORDER_CUST_CITY
	// CPTY_ORDER_CUST_COUNTRY
	// CPTY_SWIFT_CHARGES_PAID
	// SETTLEMENT_ACCOUNT
	// SETTLEMENT_MEAN
	public String getRefId() {
		return RefId;
	}

	public void setRefId(String refId) {
		RefId = refId;
	}

	public String getCounterpartyActNo() {
		return counterpartyActNo;
	}

	public void setCounterpartyActNo(String counterpartyActNo) {
		this.counterpartyActNo = counterpartyActNo;
	}

	public String getCounterpartyCurCode() {
		return counterpartyCurCode;
	}

	public void setCounterpartyCurCode(String counterpartyCurCode) {
		this.counterpartyCurCode = counterpartyCurCode;
	}

	public String getCounterpartyName() {
		return counterpartyName;
	}

	public void setCounterpartyName(String counterpartyName) {
		this.counterpartyName = counterpartyName;
	}

	public String getCounterpartyType() {
		return counterpartyType;
	}

	public void setCounterpartyType(String counterpartyType) {
		this.counterpartyType = counterpartyType;
	}

}

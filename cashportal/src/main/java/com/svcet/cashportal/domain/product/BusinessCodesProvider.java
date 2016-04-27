package com.svcet.cashportal.domain.product;

public interface BusinessCodesProvider {

	public final String ORGANIZATION_TYPE_BANK_GROUP = "BANK_GROUP";;
	public final String ORGANIZATION_TYPE_BANK = "BANK";
	public final String ORGANIZATION_TYPE_CUSTOMER = "CUSTOMER";
	public final String PRODUCT_FUNDTRANSFER_CODE = "FT";

	public final String SUB_PRODUCT_INTERNAL_FUNDTRANSFER_CODE = "INT";

	public final String FUNDTRANSFER_TYPE_INTERNAL = "01";
	public final String FUNDTRANSFER_TYPE_EXTERNAL = "02";

	public final String COUNTERPARTY_TYPE_ACCOUNT = "01";
	public final String COUNTERPARTY_TYPE_BENEFICIARY = "02";

	public final String TRANSACTION_STATUS_PENDING_APPROVAL = "03";

	public final String TRANSACTION_STATUS_RELEASED = "04";

}

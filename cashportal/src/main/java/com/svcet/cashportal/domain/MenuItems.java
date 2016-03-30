package com.svcet.cashportal.domain;

import com.svcet.cashportal.domain.acl.PermissionMaster;

public class MenuItems extends BaseEntity {
	
	private String ItemCode;
	
	private String ItemDesc;

	private PermissionMaster permissionId;

	public PermissionMaster getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(PermissionMaster permissionId) {
		this.permissionId = permissionId;
	}

	public String getItemCode() {
		return ItemCode;
	}

	public void setItemCode(String itemCode) {
		ItemCode = itemCode;
	}

	public String getItemDesc() {
		return ItemDesc;
	}

	public void setItemDesc(String itemDesc) {
		ItemDesc = itemDesc;
	}
}

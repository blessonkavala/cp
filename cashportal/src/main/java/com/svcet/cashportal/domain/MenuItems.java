package com.svcet.cashportal.domain;

import com.svcet.cashportal.domain.acl.PermissionMaster;

public class MenuItems extends BaseEntity {

	private String itemCode;

	private String itemDesc;

	private String action;

	private PermissionMaster permissionId;

	public PermissionMaster getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(PermissionMaster permissionId) {
		this.permissionId = permissionId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}

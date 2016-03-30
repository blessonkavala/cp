package com.svcet.cashportal.domain;

import java.util.List;

import javax.persistence.OneToMany;

import com.svcet.cashportal.domain.acl.PermissionMaster;

public class MenuMaster extends BaseEntity {

	private String menuCode;

	private String menuDesc;

	@OneToMany
	private List<MenuItems> menuItems;

	private PermissionMaster permissionId;

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuDesc() {
		return menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	public PermissionMaster getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(PermissionMaster permissionId) {
		this.permissionId = permissionId;
	}

	public List<MenuItems> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItems> menuItems) {
		this.menuItems = menuItems;
	}

}

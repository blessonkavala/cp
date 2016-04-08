package com.svcet.cashportal.web.beans;

import java.util.ArrayList;
import java.util.List;

public class MenuResponse {

	private String menuCode;

	private String menuDesc;

	private String action;

	List<MenuResponse> subMenu = new ArrayList<MenuResponse>();

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

	public List<MenuResponse> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<MenuResponse> subMenu) {
		this.subMenu = subMenu;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}

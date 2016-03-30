package com.svcet.cashportal.service;

import java.util.List;

import com.svcet.cashportal.domain.UserMaster;
import com.svcet.cashportal.web.beans.MenuResponse;

public interface MenuService {

	List<MenuResponse> getUserMenus(UserMaster userMaster);

}

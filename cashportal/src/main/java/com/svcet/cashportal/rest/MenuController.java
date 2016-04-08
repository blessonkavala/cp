package com.svcet.cashportal.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.svcet.cashportal.domain.OrganizationMaster;
import com.svcet.cashportal.domain.UserMaster;
import com.svcet.cashportal.security.config.UserNamePasswordOrganizationAuthenticationToken;
import com.svcet.cashportal.service.MenuService;
import com.svcet.cashportal.service.OraganizationService;
import com.svcet.cashportal.service.UserService;
import com.svcet.cashportal.web.beans.MenuResponse;

@RestController
public class MenuController {

	@Autowired
	private MenuService menuService;

	@Autowired
	private UserService userService;

	@Autowired
	private OraganizationService oraganizationService;

	@RequestMapping(method = RequestMethod.GET, value = "/usermenus")
	@ResponseBody
	public MenuResponse[] findAll() {
		UserNamePasswordOrganizationAuthenticationToken authenticationToken = (UserNamePasswordOrganizationAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();
		final String userName = authenticationToken.getName();
		final String orgName = authenticationToken.getOrganization();
		OrganizationMaster organizationMaster = oraganizationService.findByOrgName(orgName);
		UserMaster userMaster = userService.findOneByUserNameAndOrgId(userName, organizationMaster.getRid());
		List<MenuResponse> menuReponseList = menuService.getUserMenus(userMaster);
		return menuReponseList.toArray(new MenuResponse[menuReponseList.size()]);
	}
}

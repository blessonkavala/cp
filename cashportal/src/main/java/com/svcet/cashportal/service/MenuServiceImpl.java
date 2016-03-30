package com.svcet.cashportal.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svcet.cashportal.domain.MenuItems;
import com.svcet.cashportal.domain.MenuMaster;
import com.svcet.cashportal.domain.UserMaster;
import com.svcet.cashportal.domain.acl.RolePermissionMaster;
import com.svcet.cashportal.domain.acl.UserRoles;
import com.svcet.cashportal.repository.acl.MenuRepository;
import com.svcet.cashportal.repository.acl.RolePermissionMasterRepository;
import com.svcet.cashportal.repository.acl.UserRolesRepository;
import com.svcet.cashportal.web.beans.MenuResponse;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private UserRolesRepository userRolesRepository;

	@Autowired
	private RolePermissionMasterRepository rolePermissionMasterRepository;

	@Autowired
	private MenuRepository menuRepository;

	@Override
	public List<MenuResponse> getUserMenus(UserMaster userMaster) {
		List<MenuResponse> menuResponseList = new ArrayList<MenuResponse>();
		Set<String> userPermissions = new HashSet<String>();
		List<UserRoles> userRolesList = userRolesRepository.findByUserId(userMaster.getRid());
		for (UserRoles userRoles : userRolesList) {
			List<RolePermissionMaster> rolePermissionMasterList = rolePermissionMasterRepository
					.findByRoleId(userRoles.getRoleId().getRid());
			for (RolePermissionMaster rolePermissionMaster : rolePermissionMasterList) {
				userPermissions.add(rolePermissionMaster.getPermissionId().getPermissionCode());
			}
		}
		List<MenuMaster> menuList = menuRepository.findAll();
		for (MenuMaster menuMaster : menuList) {
			if (userPermissions.contains(menuMaster.getPermissionId().getPermissionCode())) {
				MenuResponse rootMenuResponse = new MenuResponse();
				BeanUtils.copyProperties(menuMaster, rootMenuResponse);
				menuResponseList.add(rootMenuResponse);
				for (MenuItems menuItems : menuMaster.getMenuItems()) {
					if (userPermissions.contains(menuItems.getPermissionId().getPermissionCode())) {
						MenuResponse childMenuResponse = new MenuResponse();
						childMenuResponse.setMenuCode(menuItems.getItemCode());
						childMenuResponse.setMenuDesc(menuItems.getItemDesc());
						rootMenuResponse.getSubMenu().add(childMenuResponse);
					}
				}
			}
		}
		return menuResponseList;
	}
}

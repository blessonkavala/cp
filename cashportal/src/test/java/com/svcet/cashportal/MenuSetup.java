package com.svcet.cashportal;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.svcet.cashportal.domain.MenuItems;
import com.svcet.cashportal.domain.MenuMaster;
import com.svcet.cashportal.domain.acl.PermissionMaster;
import com.svcet.cashportal.repository.acl.MenuRepository;
import com.svcet.cashportal.repository.acl.PermissionMasterRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CashportalApplication.class)
@WebAppConfiguration
public class MenuSetup {

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private PermissionMasterRepository permissionMasterRepository;

	@Test
	public void main() {
		menuRepository.deleteAll();
		setupBankMaintenanceMenus();
		setupCustomerMaintenanceMenus();
	}

	private void setupCustomerMaintenanceMenus() {
		
		MenuMaster menuMaster = new MenuMaster();
		menuMaster.setMenuCode("Customer Maintenace");
		menuMaster.setMenuDesc("Customer Maintenace");
		PermissionMaster rootPermissionMaster = permissionMasterRepository
				.findByPermissionCode("ba_customer_maintenance_access");
		menuMaster.setPermissionId(rootPermissionMaster);

		MenuItems menuItemsProfile = new MenuItems();
		menuItemsProfile.setItemCode("Profiles");
		menuItemsProfile.setItemDesc("Profiles");
		menuItemsProfile.setAction("app.listBanks");
		PermissionMaster permissionMasterProfiles = permissionMasterRepository
				.findByPermissionCode("ba_customer_profile_access");
		menuItemsProfile.setPermissionId(permissionMasterProfiles);

		MenuItems menuItemsPermission = new MenuItems();
		menuItemsPermission.setItemCode("Permissions");
		menuItemsPermission.setItemDesc("Permissions Desc");
		menuItemsPermission.setAction("app.listBankPermissions");
		PermissionMaster permissionMasterPermission = permissionMasterRepository
				.findByPermissionCode("ba_customer_profile_permissions_access");
		menuItemsPermission.setPermissionId(permissionMasterPermission);

		MenuItems menuItemsUserProfile = new MenuItems();
		menuItemsUserProfile.setItemCode("User Profile");
		menuItemsUserProfile.setItemDesc("User Profile");
		menuItemsUserProfile.setAction("app.listBanksForSelection({ targetUIState: \"app.listBankUsers\"})");
		PermissionMaster permissionUserProfile = permissionMasterRepository
				.findByPermissionCode("ba_customer_user_profile_access");
		menuItemsUserProfile.setPermissionId(permissionUserProfile);
		
		MenuItems menuItemsUserProfilePermission = new MenuItems();
		menuItemsUserProfilePermission.setItemCode("User Permissions");
		menuItemsUserProfilePermission.setItemDesc("User Permissions");
		menuItemsUserProfilePermission.setAction("app.listBanksForSelection({ targetUIState: \"app.listBankUsersPermissions\"})");
		PermissionMaster permissionUserProfilePermissions = permissionMasterRepository
				.findByPermissionCode("ba_customer_user_profile_permissions_access");
		menuItemsUserProfilePermission.setPermissionId(permissionUserProfilePermissions);
		
		List<MenuItems> menuItemsList = new ArrayList<MenuItems>();
		menuItemsList.add(menuItemsProfile);
		menuItemsList.add(menuItemsPermission);
		menuItemsList.add(menuItemsUserProfile);
		menuItemsList.add(menuItemsUserProfilePermission);
		menuMaster.setMenuItems(menuItemsList);

		menuRepository.save(menuMaster);
	}

	public void setupBankMaintenanceMenus() {
		
		MenuMaster menuMaster = new MenuMaster();
		menuMaster.setMenuCode("Bank Maintenance");
		menuMaster.setMenuDesc("Bank Maintenance");
		PermissionMaster rootPermissionMaster = permissionMasterRepository
				.findByPermissionCode("bga_bank_maintenance_access");
		menuMaster.setPermissionId(rootPermissionMaster);

		MenuItems menuItemsProfile = new MenuItems();
		menuItemsProfile.setItemCode("Profiles");
		menuItemsProfile.setItemDesc("Profiles");
		menuItemsProfile.setAction("app.listBanks");
		PermissionMaster permissionMasterProfiles = permissionMasterRepository
				.findByPermissionCode("bga_bank_profile_access");
		menuItemsProfile.setPermissionId(permissionMasterProfiles);

		MenuItems menuItemsPermission = new MenuItems();
		menuItemsPermission.setItemCode("Permissions");
		menuItemsPermission.setItemDesc("Permissions Desc");
		menuItemsPermission.setAction("app.listBankPermissions");
		PermissionMaster permissionMasterPermission = permissionMasterRepository
				.findByPermissionCode("bga_bank_profile_permissions_access");
		menuItemsPermission.setPermissionId(permissionMasterPermission);

		MenuItems menuItemsUserProfile = new MenuItems();
		menuItemsUserProfile.setItemCode("User Profile");
		menuItemsUserProfile.setItemDesc("User Profile");
		menuItemsUserProfile.setAction("app.listBanksForSelection({ targetUIState: \"app.listBankUsers\"})");
		PermissionMaster permissionUserProfile = permissionMasterRepository
				.findByPermissionCode("bga_bank_user_profile_access");
		menuItemsUserProfile.setPermissionId(permissionUserProfile);
		
		MenuItems menuItemsUserProfilePermission = new MenuItems();
		menuItemsUserProfilePermission.setItemCode("User Permissions");
		menuItemsUserProfilePermission.setItemDesc("User Permissions");
		menuItemsUserProfilePermission.setAction("app.listBanksForSelection({ targetUIState: \"app.listBankUsersPermissions\"})");
		PermissionMaster permissionUserProfilePermissions = permissionMasterRepository
				.findByPermissionCode("bga_bank_user_profile_permissions_access");
		menuItemsUserProfilePermission.setPermissionId(permissionUserProfilePermissions);
		
		List<MenuItems> menuItemsList = new ArrayList<MenuItems>();
		menuItemsList.add(menuItemsProfile);
		menuItemsList.add(menuItemsPermission);
		menuItemsList.add(menuItemsUserProfile);
		menuItemsList.add(menuItemsUserProfilePermission);
		menuMaster.setMenuItems(menuItemsList);

		menuRepository.save(menuMaster);
	}

	public void menuJurisDiction() {
		MenuMaster menuMaster = new MenuMaster();
		menuMaster.setMenuCode("Jurisdiction Maintenance");
		menuMaster.setMenuDesc("Jurisdiction Maintenance");

		PermissionMaster rootPermissionMaster = permissionMasterRepository
				.findByPermissionCode("bga_jurisdiction_maintenance_access");
		menuMaster.setPermissionId(rootPermissionMaster);

		MenuItems menuItemsRoles = new MenuItems();
		menuItemsRoles.setItemCode("Roles");
		menuItemsRoles.setItemDesc("Roles Desc");
		PermissionMaster bgaRoleAccessPermission = permissionMasterRepository.findByPermissionCode("bga_roles_access");
		menuItemsRoles.setPermissionId(bgaRoleAccessPermission);

		List<MenuItems> menuItemsList = new ArrayList<MenuItems>();
		menuItemsList.add(menuItemsRoles);

		menuMaster.setMenuItems(menuItemsList);

		menuRepository.save(menuMaster);
	}

	public void menuBankUser() {
		MenuMaster menuMaster = new MenuMaster();
		menuMaster.setMenuCode("User Profile");
		menuMaster.setMenuDesc("User Profile");

		PermissionMaster rootPermissionMaster = permissionMasterRepository.findByPermissionCode("no_permission");
		menuMaster.setPermissionId(rootPermissionMaster);

		MenuItems menuItemsRoles = new MenuItems();
		menuItemsRoles.setItemCode("Roles");
		menuItemsRoles.setItemDesc("Roles Desc");
		PermissionMaster bgaRoleAccessPermission = permissionMasterRepository.findByPermissionCode("bga_roles_access");
		menuItemsRoles.setPermissionId(bgaRoleAccessPermission);

		List<MenuItems> menuItemsList = new ArrayList<MenuItems>();
		menuItemsList.add(menuItemsRoles);

		menuMaster.setMenuItems(menuItemsList);

		menuRepository.save(menuMaster);
	}

}

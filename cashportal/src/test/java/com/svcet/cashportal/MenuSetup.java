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
		setupMiddleOfficeMenus();
		setupCashInternalFundTransferMenus();
	}

	private void setupMiddleOfficeMenus() {
		MenuMaster menuMiddleOffice = new MenuMaster();
		menuMiddleOffice.setMenuCode("Middle Office");
		menuMiddleOffice.setMenuDesc("Middle Office");
		PermissionMaster permissionMOAccess = permissionMasterRepository.findByPermissionCode("mo_access");
		menuMiddleOffice.setPermissionId(permissionMOAccess);

		MenuItems menuItemsMOPendingRecords = new MenuItems();
		menuItemsMOPendingRecords.setItemCode("Pending Records");
		menuItemsMOPendingRecords.setItemDesc("Pending Records");
		menuItemsMOPendingRecords.setAction("app.listMOPendingRecords");
		PermissionMaster permissionMasterProfiles = permissionMasterRepository
				.findByPermissionCode("mo_pending_record_access");
		menuItemsMOPendingRecords.setPermissionId(permissionMasterProfiles);

		MenuItems menuItemsMOExistingRecords = new MenuItems();
		menuItemsMOExistingRecords.setItemCode("Existing Records");
		menuItemsMOExistingRecords.setItemDesc("Existing Records");
		menuItemsMOExistingRecords.setAction("app.listMOExistingRecords");
		PermissionMaster permissionMasterPermission = permissionMasterRepository
				.findByPermissionCode("mo_existing_record_access");
		menuItemsMOExistingRecords.setPermissionId(permissionMasterPermission);
		
		List<MenuItems> menuItemsList = new ArrayList<MenuItems>();
		menuItemsList.add(menuItemsMOPendingRecords);
		menuItemsList.add(menuItemsMOExistingRecords);
		menuMiddleOffice.setMenuItems(menuItemsList);

		menuRepository.save(menuMiddleOffice);
	}

	private void setupCashInternalFundTransferMenus() {

		MenuMaster menuMaster = new MenuMaster();
		menuMaster.setMenuCode("Internal Fundtransfer");
		menuMaster.setMenuDesc("Internal Fundtransfer");
		PermissionMaster rootPermissionMaster = permissionMasterRepository.findByPermissionCode("cash_ft_int_access");
		menuMaster.setPermissionId(rootPermissionMaster);

		MenuItems menuItemsInitiateFT = new MenuItems();
		menuItemsInitiateFT.setItemCode("Initiate");
		menuItemsInitiateFT.setItemDesc("Initiate");
		menuItemsInitiateFT.setAction("app.initInternalFT");
		PermissionMaster permissionMasterProfiles = permissionMasterRepository
				.findByPermissionCode("cash_ft_int_create");
		menuItemsInitiateFT.setPermissionId(permissionMasterProfiles);

		MenuItems menuItemsPendingFts = new MenuItems();
		menuItemsPendingFts.setItemCode("Pending Fundtransfer");
		menuItemsPendingFts.setItemDesc("Pending Fundtransfer");
		menuItemsPendingFts.setAction("app.listPendingFTs");
		PermissionMaster permissionMasterPermission = permissionMasterRepository
				.findByPermissionCode("cash_ft_int_pending_list_access");
		menuItemsPendingFts.setPermissionId(permissionMasterPermission);

		MenuItems menuItemsFTInquiry = new MenuItems();
		menuItemsFTInquiry.setItemCode("Inquiry Fundtransfer");
		menuItemsFTInquiry.setItemDesc("Inquiry Fundtransfer");
		menuItemsFTInquiry.setAction("app.listInquiryFTs");
		PermissionMaster permissionUserProfile = permissionMasterRepository
				.findByPermissionCode("cash_ft_int_inquiry_list_access");
		menuItemsFTInquiry.setPermissionId(permissionUserProfile);

		List<MenuItems> menuItemsList = new ArrayList<MenuItems>();
		menuItemsList.add(menuItemsInitiateFT);
		menuItemsList.add(menuItemsPendingFts);
		menuItemsList.add(menuItemsFTInquiry);
		menuMaster.setMenuItems(menuItemsList);

		menuRepository.save(menuMaster);

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
		menuItemsProfile.setAction("app.listCustomers");
		PermissionMaster permissionMasterProfiles = permissionMasterRepository
				.findByPermissionCode("ba_customer_profile_access");
		menuItemsProfile.setPermissionId(permissionMasterProfiles);

		MenuItems menuItemsPermission = new MenuItems();
		menuItemsPermission.setItemCode("Permissions");
		menuItemsPermission.setItemDesc("Permissions Desc");
		menuItemsPermission.setAction("app.listCustomerPermissions");
		PermissionMaster permissionMasterPermission = permissionMasterRepository
				.findByPermissionCode("ba_customer_profile_permissions_access");
		menuItemsPermission.setPermissionId(permissionMasterPermission);

		MenuItems menuItemsUserProfile = new MenuItems();
		menuItemsUserProfile.setItemCode("User Profile");
		menuItemsUserProfile.setItemDesc("User Profile");
		menuItemsUserProfile.setAction("app.listCustomersForSelection({ targetUIState: \"app.listCustomerUsers\"})");
		PermissionMaster permissionUserProfile = permissionMasterRepository
				.findByPermissionCode("ba_customer_user_profile_access");
		menuItemsUserProfile.setPermissionId(permissionUserProfile);

		MenuItems menuItemsUserProfilePermission = new MenuItems();
		menuItemsUserProfilePermission.setItemCode("User Permissions");
		menuItemsUserProfilePermission.setItemDesc("User Permissions");
		menuItemsUserProfilePermission
				.setAction("app.listCustomersForSelection({ targetUIState: \"app.listCustomerUsersPermissions\"})");
		PermissionMaster permissionUserProfilePermissions = permissionMasterRepository
				.findByPermissionCode("ba_customer_user_profile_permissions_access");
		menuItemsUserProfilePermission.setPermissionId(permissionUserProfilePermissions);

		MenuItems menuItemsUserAuthentication = new MenuItems();
		menuItemsUserAuthentication.setItemCode("User Authentication");
		menuItemsUserAuthentication.setItemDesc("User Authentication");
		menuItemsUserAuthentication
				.setAction("app.listCustomersForSelection({ targetUIState: \"app.listCustomerUsersPermissions\"})");
		PermissionMaster permissionUserAuthentication = permissionMasterRepository
				.findByPermissionCode("ba_customer_user_authentication_access");
		menuItemsUserAuthentication.setPermissionId(permissionUserAuthentication);

		MenuItems menuItemsCompanyAccounts = new MenuItems();
		menuItemsCompanyAccounts.setItemCode("Company Accounts");
		menuItemsCompanyAccounts.setItemDesc("Company Accounts");
		menuItemsCompanyAccounts
				.setAction("app.listCustomersForSelection({ targetUIState: \"app.listCustomerAccounts\"})");
		PermissionMaster permissionCompanyAccounts = permissionMasterRepository
				.findByPermissionCode("ba_customer_accounts_access");
		menuItemsCompanyAccounts.setPermissionId(permissionCompanyAccounts);
		
		MenuItems menuItemsUserAccounts = new MenuItems();
		menuItemsUserAccounts.setItemCode("User Accounts");
		menuItemsUserAccounts.setItemDesc("User Accounts");
		menuItemsUserAccounts
				.setAction("app.listCustomersForSelection({ targetUIState: \"app.listUserAccounts\"})");
		PermissionMaster permissionUserAccounts = permissionMasterRepository
				.findByPermissionCode("ba_customer_user_accounts_access");
		menuItemsUserAccounts.setPermissionId(permissionUserAccounts);

		MenuItems menuItemsBeneficiaryMaster = new MenuItems();
		menuItemsBeneficiaryMaster.setItemCode("Beneficiary Master");
		menuItemsBeneficiaryMaster.setItemDesc("Beneficiary Master");
		menuItemsBeneficiaryMaster
				.setAction("app.listCustomersForSelection({ targetUIState: \"app.listCustomerUsersPermissions\"})");
		PermissionMaster permissionBeneficiaryMaster = permissionMasterRepository
				.findByPermissionCode("ba_customer_beneficiary_access");
		menuItemsBeneficiaryMaster.setPermissionId(permissionBeneficiaryMaster);

		List<MenuItems> menuItemsList = new ArrayList<MenuItems>();
		menuItemsList.add(menuItemsProfile);
		menuItemsList.add(menuItemsPermission);
		menuItemsList.add(menuItemsUserProfile);
		menuItemsList.add(menuItemsUserProfilePermission);
		menuItemsList.add(menuItemsUserAuthentication);
		menuItemsList.add(menuItemsCompanyAccounts);
		menuItemsList.add(menuItemsUserAccounts);
		menuItemsList.add(menuItemsBeneficiaryMaster);
		
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
		menuItemsUserProfilePermission
				.setAction("app.listBanksForSelection({ targetUIState: \"app.listBankUsersPermissions\"})");
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

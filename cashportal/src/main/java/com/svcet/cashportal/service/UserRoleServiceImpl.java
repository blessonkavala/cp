package com.svcet.cashportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svcet.cashportal.domain.UserMaster;
import com.svcet.cashportal.domain.acl.OrganizationRoles;
import com.svcet.cashportal.domain.acl.UserRoles;
import com.svcet.cashportal.repository.OrganizationRoleRepository;
import com.svcet.cashportal.repository.RoleMasterRepository;
import com.svcet.cashportal.repository.UserRepository;
import com.svcet.cashportal.repository.acl.UserRolesRepository;
import com.svcet.cashportal.web.beans.OrganizationReponse;
import com.svcet.cashportal.web.beans.RoleRequest;
import com.svcet.cashportal.web.beans.RoleResponse;
import com.svcet.cashportal.web.beans.UserRequest;
import com.svcet.cashportal.web.beans.UserResponse;
import com.svcet.cashportal.web.beans.UserRolesScreenRequest;
import com.svcet.cashportal.web.beans.UserRolesScreenResponse;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserService userService;

	@Autowired
	private OraganizationService oraganizationService;

	@Autowired
	private UserRolesRepository userRolesRepository;

	@Autowired
	private OrganizationRoleRepository organizationRoleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleMasterRepository roleMasterRepository;

	@Override
	public UserRolesScreenResponse editUserRoles(UserRequest userRequest) {

		UserRolesScreenResponse userRolesScreenResponse = new UserRolesScreenResponse();

		// FETCH ORGANIZATION DETAILS
		UserResponse userReponse = userService.findById(userRequest.getRid());

		userRolesScreenResponse.setUser(userReponse);

		// FETCH Asigned ROLES
		List<UserRoles> assignedUserRolesList = userRolesRepository.findByUserId(userReponse.getRid());
		List<String> assignedRoleIdList = new ArrayList<String>();

		List<RoleResponse> assignedRoleResponseList = new ArrayList<RoleResponse>();
		for (UserRoles userRoles : assignedUserRolesList) {
			assignedRoleIdList.add(userRoles.getRoleId().getRoleCode());
			RoleResponse roleResponse = new RoleResponse();
			BeanUtils.copyProperties(userRoles.getRoleId(), roleResponse);
			assignedRoleResponseList.add(roleResponse);
		}

		OrganizationReponse organizationReponse = oraganizationService.findById(userReponse.getOrgId());

		// Fetch Available Roles
		List<OrganizationRoles> availableOrganizationRolesList = organizationRoleRepository
				.findByOrgIdAndRoleDest(organizationReponse.getRid(), organizationReponse.getOrgType());
		List<RoleResponse> availableRoleResponseList = new ArrayList<RoleResponse>();
		for (OrganizationRoles organizationRoles : availableOrganizationRolesList) {
			if (!assignedRoleIdList.contains(organizationRoles.getRoleId().getRoleCode())) {
				RoleResponse roleResponse = new RoleResponse();
				BeanUtils.copyProperties(organizationRoles.getRoleId(), roleResponse);
				availableRoleResponseList.add(roleResponse);
			}
		}
		userRolesScreenResponse.setAssignedRoles(assignedRoleResponseList);
		userRolesScreenResponse.setAvailableRoles(availableRoleResponseList);
		return userRolesScreenResponse;
	}

	@Override
	public void updateUserRoles(UserRolesScreenRequest userRolesScreenRequest) {
		// DELETE ALL EXISTING User Roles
		List<UserRoles> existsingUserRolesList = userRolesRepository
				.findByUserId(userRolesScreenRequest.getUser().getRid());
		userRolesRepository.delete(existsingUserRolesList);
		List<RoleRequest> assignedRolesList = userRolesScreenRequest.getAssignedRoles();
		UserMaster userMaster = userRepository.findByRid(userRolesScreenRequest.getUser().getRid());
		for (RoleRequest roleRequest : assignedRolesList) {
			UserRoles userRoles = new UserRoles();
			userRoles.setUserId(userMaster);
			userRoles.setRoleId(roleMasterRepository.findByRoleCode(roleRequest.getRoleCode()));
			userRolesRepository.save(userRoles);
		}
	}
}

package com.svcet.cashportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svcet.cashportal.domain.OrganizationMaster;
import com.svcet.cashportal.domain.acl.OrganizationRoles;
import com.svcet.cashportal.repository.OrganizationRepository;
import com.svcet.cashportal.repository.OrganizationRoleRepository;
import com.svcet.cashportal.repository.RoleMasterRepository;
import com.svcet.cashportal.web.beans.OrganizationReponse;
import com.svcet.cashportal.web.beans.OrganizationRequest;
import com.svcet.cashportal.web.beans.OrganizationRoleVO;
import com.svcet.cashportal.web.beans.OrganizationRolesScreenRequest;
import com.svcet.cashportal.web.beans.OrganizationRolesScreenResponse;
import com.svcet.cashportal.web.beans.RoleRequest;
import com.svcet.cashportal.web.beans.RoleResponse;

@Service
public class OrganizationRolesServiceImpl implements OrganizationRolesService {

	@Autowired
	private OrganizationRoleRepository organizationRoleRepository;

	@Autowired
	private OrganizationRepository OrganizationRepository;

	@Autowired
	private OraganizationService oraganizationService;

	@Autowired
	private RoleMasterRepository roleMasterRepository;

	@Override
	public List<OrganizationRoleVO> findById(String organizationId) {
		List<OrganizationRoleVO> organizationRoleResponseList = new ArrayList<OrganizationRoleVO>();
		List<OrganizationRoles> organizationRolesList = organizationRoleRepository.findByOrgId(organizationId);
		for (OrganizationRoles organizationRoles : organizationRolesList) {
			OrganizationRoleVO organizationRoleResponse = new OrganizationRoleVO();
			OrganizationReponse organizationReponse = new OrganizationReponse();
			BeanUtils.copyProperties(organizationRoles.getOrgId(), organizationReponse);
			RoleResponse roleResponse = new RoleResponse();
			BeanUtils.copyProperties(organizationRoles.getRoleId(), roleResponse);
			organizationRoleResponse.setOrganization(organizationReponse);
			organizationRoleResponse.setRole(roleResponse);
			organizationRoleResponseList.add(organizationRoleResponse);
		}
		return organizationRoleResponseList;
	}

	@Override
	public OrganizationRolesScreenResponse editOrganizationRoles(OrganizationRequest organizationRequest) {
		OrganizationRolesScreenResponse organizationRolesScreenResponse = new OrganizationRolesScreenResponse();

		// FETCH ORGANIZATION DETAILS
		OrganizationReponse organizationReponse = oraganizationService.findById(organizationRequest.getRid());

		organizationRolesScreenResponse.setOrganization(organizationReponse);

		// FETCH Asigned ROLES
		List<OrganizationRoles> assignedOrganizationRolesList = organizationRoleRepository
				.findByOrgId(organizationReponse.getRid());
		List<String> assignedRoleIdList = new ArrayList<String>();

		List<RoleResponse> assignedRoleResponseList = new ArrayList<RoleResponse>();
		for (OrganizationRoles organizationRoles : assignedOrganizationRolesList) {
			assignedRoleIdList.add(organizationRoles.getRoleId().getRoleCode());
			RoleResponse roleResponse = new RoleResponse();
			BeanUtils.copyProperties(organizationRoles.getRoleId(), roleResponse);
			assignedRoleResponseList.add(roleResponse);
		}

		// Fetch Available Roles
		List<OrganizationRoles> availableOrganizationRolesList = organizationRoleRepository
				.findByOrgIdAndRoleDest(organizationReponse.getParentOrgId(), organizationReponse.getOrgType());
		List<RoleResponse> availableRoleResponseList = new ArrayList<RoleResponse>();
		for (OrganizationRoles organizationRoles : availableOrganizationRolesList) {
			if (!assignedRoleIdList.contains(organizationRoles.getRoleId().getRoleCode())) {
				RoleResponse roleResponse = new RoleResponse();
				BeanUtils.copyProperties(organizationRoles.getRoleId(), roleResponse);
				availableRoleResponseList.add(roleResponse);
			}
		}
		organizationRolesScreenResponse.setAssignedRoles(assignedRoleResponseList);
		organizationRolesScreenResponse.setAvailableRoles(availableRoleResponseList);
		return organizationRolesScreenResponse;
	}

	@Override
	public void updateOrganizationRoles(OrganizationRolesScreenRequest organizationRolesScreenRequest) {
		// DELETE ALL EXISTING ORGANIZATION MATCHING THE ROLE DESTINATION (BANK
		// OR CUSTOMER)
		List<OrganizationRoles> existsingOrganizationRolesList = organizationRoleRepository.findByOrgIdAndRoleDest(
				organizationRolesScreenRequest.getOrganization().getRid(),
				organizationRolesScreenRequest.getOrganization().getOrgType());
		organizationRoleRepository.delete(existsingOrganizationRolesList);
		List<RoleRequest> assignedRolesList = organizationRolesScreenRequest.getAssignedRoles();
		OrganizationMaster organizationMaster = OrganizationRepository
				.findByRid(organizationRolesScreenRequest.getOrganization().getRid());
		for (RoleRequest roleRequest : assignedRolesList) {
			OrganizationRoles organizationRoles = new OrganizationRoles();
			organizationRoles.setOrgId(organizationMaster);
			organizationRoles.setRoleId(roleMasterRepository.findByRoleCode(roleRequest.getRoleCode()));
			organizationRoleRepository.save(organizationRoles);
		}
	}
}

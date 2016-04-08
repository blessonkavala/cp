package com.svcet.cashportal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.svcet.cashportal.service.UserRoleService;
import com.svcet.cashportal.web.beans.UserRequest;
import com.svcet.cashportal.web.beans.UserRolesScreenRequest;
import com.svcet.cashportal.web.beans.UserRolesScreenResponse;

@RestController
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/userroles/query")
	public UserRolesScreenResponse findAll(@RequestBody UserRequest userRequest) {
		return userRoleService.editUserRoles(userRequest);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/userroles/update")
	public void update(@RequestBody UserRolesScreenRequest userRolesScreenRequest) {
		userRoleService.updateUserRoles(userRolesScreenRequest);
	}

}

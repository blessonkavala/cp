package com.svcet.cashportal.service;

import com.svcet.cashportal.web.beans.UserRequest;
import com.svcet.cashportal.web.beans.UserRolesScreenRequest;
import com.svcet.cashportal.web.beans.UserRolesScreenResponse;

public interface UserRoleService {

	UserRolesScreenResponse editUserRoles(UserRequest userRequest);

	void updateUserRoles(UserRolesScreenRequest userRolesScreenRequest);

}

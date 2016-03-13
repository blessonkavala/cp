package com.svcet.cashportal.service;

import com.svcet.cashportal.domain.UserMaster;
import com.svcet.cashportal.web.beans.UserRequest;
import com.svcet.cashportal.web.beans.UserResponse;

public interface UserService {

	UserMaster findUserByUserNamePasswordOrgName(String userName,String password,String orgName);

	UserMaster save(UserMaster userMaster);

	UserResponse save(UserRequest userRequest);
}

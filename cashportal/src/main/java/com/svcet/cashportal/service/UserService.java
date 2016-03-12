package com.svcet.cashportal.service;

import com.svcet.cashportal.domain.UserMaster;

public interface UserService {

	UserMaster findUserByUserNamePasswordOrgName(String userName,String password,String orgName);

	UserMaster save(UserMaster userMaster);
}

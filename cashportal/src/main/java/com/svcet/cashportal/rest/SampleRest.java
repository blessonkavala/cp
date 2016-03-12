/**
 * 
 */
package com.svcet.cashportal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.svcet.cashportal.domain.UserMaster;
import com.svcet.cashportal.security.config.LoginRequest;
import com.svcet.cashportal.service.UserService;

/**
 * GENERATED!! from contract
 * 
 * @author lsomogyi
 *
 */
@RestController
public class SampleRest {

	@Autowired
	private UserService userService;

	/**
	 * Generated comment.
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/user")
	public UserMaster findOneByName(@RequestBody LoginRequest loginRequest) {
		return userService.findUserByUserNamePasswordOrgName(loginRequest.getUsername(), loginRequest.getPassword(),
				loginRequest.getOrganization());
	}
}

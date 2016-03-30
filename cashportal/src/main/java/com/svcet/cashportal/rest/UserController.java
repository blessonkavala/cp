package com.svcet.cashportal.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.svcet.cashportal.service.UserService;
import com.svcet.cashportal.web.beans.UserRequest;
import com.svcet.cashportal.web.beans.UserResponse;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/user/save")
	@ResponseBody
	public UserResponse save(@RequestBody UserRequest userRequest) {
		return userService.save(userRequest);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/user/query")
	@ResponseBody
	public UserResponse findOne(@RequestBody UserRequest userRequest) {
		return userService.findById(userRequest.getRid());
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/user/update")
	@ResponseBody
	public UserResponse update(@RequestBody UserRequest userRequest) {
		return userService.update(userRequest);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/user/list")
	@ResponseBody
	public UserResponse[] findAll(@RequestBody UserRequest userRequest) {
		List<UserResponse> userResponseList = userService.findAll(userRequest.getOrgId());
		return userResponseList.toArray(new UserResponse[userResponseList.size()]);
	}

}

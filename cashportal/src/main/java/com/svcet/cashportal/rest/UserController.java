package com.svcet.cashportal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	@ResponseBody
	public UserResponse findOne(@PathVariable("id") String id) {
		return userService.findById(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/user/update")
	@ResponseBody
	public UserResponse update(@RequestBody UserRequest userRequest) {
		return userService.update(userRequest);
	}

}

package com.svcet.cashportal.exception;

import com.svcet.cashportal.web.beans.UserRequest;

public class DuplicateUserException extends RuntimeException {

	private UserRequest userRequest;

	public DuplicateUserException(UserRequest userRequest) {
		this.userRequest = userRequest;
	}

	public UserRequest getUserRequest() {
		return userRequest;
	}
}

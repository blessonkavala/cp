package com.svcet.cashportal.web.beans;

public class ErrorModel {

	private String message;

	public ErrorModel(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

package com.productapp.user.service;

public class UserInvalidateException extends RuntimeException{

	public UserNotFoundException(String message) {
		super(message);
	}
}
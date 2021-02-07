package com.product.user.service;

import com.productapp.user.UserDetails;

public interface UserService {
	
	public void addUser(UserDetails user);

	public void updatePassword(String password, String userName);

	public UserDetails getUser(String username, String password);
}
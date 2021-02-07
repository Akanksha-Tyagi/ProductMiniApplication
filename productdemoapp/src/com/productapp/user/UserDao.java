package com.productapp.user;

import java.util.*;
public interface UserDao {
	public void addUser(UserDetails user);
	public void updatePassword(String password,String userName);
	public UserDetails getUser(String username, String password);
}
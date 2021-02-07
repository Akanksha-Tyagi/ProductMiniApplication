package com.product.user.service;


import com.productapp.user.UserDao;
import com.productapp.user.UserDaoImpl;
import com.productapp.user.UserDetails;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public void addUser(UserDetails user) {
		userDao.addUser(user);

	}

	@Override
	public UserDetails getUser(String username, String password) {
		return userDao.getUser(username, password);
	}

	@Override
	public void updatePassword(String password,String userName) {
		userDao.updatePassword(password,userName);
		
	}

}
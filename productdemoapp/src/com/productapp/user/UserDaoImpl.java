package com.productapp.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.productapp.dao.ConnectionFactory;
import com.productapp.dao.DataAccessException;

public class UserDaoImpl implements UserDao {

	private Connection connection;

	public UserDaoImpl() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void addUser(UserDetails user) {
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("insert into userlogindetails(username, password) values(?,?)");

			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.executeUpdate();

		} catch (SQLException ex) {
			throw new DataAccessException(ex.getCause().toString());
		}
	}

	@Override
	public UserDetails getUser(String username, String password) {
		UserDetails user = null;
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("select * from userlogindetails where username=? and password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new UserDetails(rs.getString(1), rs.getString(2));
			} else {
				throw new UserNotFoundException("user with name : " + username + " is not found");
			}

		} catch (SQLException e) {
			throw new DataAccessException(e.getMessage());
		}
		return user;
	}

	@Override
	public void updatePassword(String password, String userName) {
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("update userlogindetails set password=? where username=? ");

			pstmt.setString(1, password);
			pstmt.setString(2, userName);
			pstmt.executeUpdate();

		} catch (SQLException ex) {
			throw new DataAccessException(ex.getCause().toString());
		}

	}

}
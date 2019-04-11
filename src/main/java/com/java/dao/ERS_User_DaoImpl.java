package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.java.util.*;
import com.java.objects.*;

public class ERS_User_DaoImpl implements ERS_User_Dao {
	private Connection conn;

	public Set<ERS_User> getAllUser() {
		conn = DBUtil.getInstance();
		Set<ERS_User> allUsers = new HashSet<ERS_User>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from ers_user");
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				ERS_User temp = extractAndFormatData(result);
				allUsers.add(temp);
			}
		} catch (SQLException e) {
			System.out.println("Unable to connect! Please try again");
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					/* ignored */}
		}
		return allUsers;
	}

	public ERS_User getUserWithLogin(String usernameInput, String passwordInput) {
		conn = DBUtil.getInstance();
		ERS_User user = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from ers_user where user_username=? AND user_password=?");
			ps.setString(1, usernameInput);
			ps.setString(2, passwordInput);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				user = extractAndFormatData(result);
			}
		} catch (SQLException e) {
			System.out.println("Unable to connect! Please try again");
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					/* ignored */}
		}
		return user;
	}

	private ERS_User extractAndFormatData(ResultSet rs) {
		ERS_User user = new ERS_User();
		try {
			user.setUserID(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setFirstName(rs.getString(4));
			user.setLastName(rs.getString(5));
			user.setEmail(rs.getString(6));
			user.setUserRole(rs.getInt(7));
		} catch (SQLException e) {
			/**/
		}

		return user;
	}
}

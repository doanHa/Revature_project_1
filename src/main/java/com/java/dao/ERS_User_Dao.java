package com.java.dao;

import java.util.Set;

import com.java.objects.ERS_User;

public interface ERS_User_Dao {
	Set<ERS_User> getAllUser();
	ERS_User getUserWithLogin(String usernameInput, String passwordInput);
}

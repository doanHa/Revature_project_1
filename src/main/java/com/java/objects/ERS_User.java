package com.java.objects;

public class ERS_User {
	private String username, password, first_name, last_name, email;
	private int userID, user_role;

	public ERS_User(String u_name, String pword, String f_name, String l_name, String e_mail, int u_id, int u_role) {
		username = u_name;
		password = pword;
		first_name = f_name;
		last_name = l_name;
		email = e_mail;
		userID = u_id;
		user_role = u_role;
	}
	public ERS_User(String u_name, String pword, String f_name, String l_name, int u_id, int u_role) {
		username = u_name;
		password = pword;
		first_name = f_name;
		last_name = l_name;
		email = "";
		userID = u_id;
		user_role = u_role;
	}
	public ERS_User() {
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return first_name;
	}

	public String getLastName() {
		return last_name;
	}
	
	public String getEmail() {
		return email;
	}
	public int getUserId() {
		return userID;
	}
	public int getUserRoleID() {
		return user_role;
	}
	public String getUserRole() {
		switch(user_role) {
		case 1: return "Manager";
		case 2: return "Salesperson";
		case 3: return "Engineer";
		case 4: return "Accountant";
		case 5: return "Designer";
		}
		return null;
	}
	public void setUsername(String _username) {
		username = _username;
	}
	public void setPassword(String _password) {
		password = _password;
	}
	public void setFirstName(String _firstname) {
		first_name = _firstname;
	}
	public void setLastName(String _lastname) {
		last_name = _lastname;
	}
	public void setEmail(String _email) {
		email = _email;
	}
	public void setUserID(int _userid) {
		userID = _userid;
	}
	public void setUserRole(int _userrole) {
		user_role = _userrole;
	}
	
}

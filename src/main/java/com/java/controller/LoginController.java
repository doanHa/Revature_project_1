package com.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.java.dao.ERS_User_DaoImpl;
import com.java.objects.ERS_User;

public class LoginController{

	public static String login(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		ERS_User_DaoImpl userDao = new ERS_User_DaoImpl();
		HttpSession s = req.getSession();
		ERS_User user = userDao.getUserWithLogin(username, password);
		if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
			s.setAttribute("User", user);
			s.setAttribute("userid", user.getUserId());
			if(user.getUserRoleID() == 1)
				return "manager.html";
			return "employee.html";
		}
		return "index.html";
	}
	public static String goHome(HttpServletRequest req) {
		HttpSession s = req.getSession();
		if(s==null) return "index.html";
		ERS_User user = (ERS_User)req.getAttribute("User");
		if(user.getUserRoleID() == 1)
			return "manager.html";
		return "employee.html";
	}
}
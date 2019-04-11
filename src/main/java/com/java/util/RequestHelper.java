package com.java.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.controller.LoginController;
import com.java.controller.SubmitTicketController;

public class RequestHelper {
	public static String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getRequestURI());
		switch(req.getRequestURI()) {
		case "/ExpenseReimbursementSystem/validate.do":
			return LoginController.login(req);
		case "/ExpenseReimbursementSystem/createNewRequest.do":
			return "create-ticket.html";
		case "/ExpenseReimbursementSystem/submit.do":
			return SubmitTicketController.submit(req);
		case "/ExpenseReimbursementSystem/logout.do":
			req.getSession().invalidate();
		default: return "index.html";
		}
	}
}

package com.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.java.dao.ERS_Ticket_DaoImpl;
import com.java.objects.ERS_User;
import com.java.objects.ReimbursementTicket;

public class ManagerTicketController {
	public static String resolve(HttpServletRequest req) {
		HttpSession s = req.getSession();
		ERS_Ticket_DaoImpl ticket = new ERS_Ticket_DaoImpl();
		if(req.getParameter("approve-button")!= null) {
			ticket.updateApproval(Integer.parseInt(req.getParameter("approve-button")), ((ERS_User)s.getAttribute("User")).getUserId(), 2);
		} else {
			ticket.updateApproval(Integer.parseInt(req.getParameter("deny-button")), ((ERS_User)s.getAttribute("User")).getUserId(), 3);
		}
		return "manager.html";
	}
}

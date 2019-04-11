package com.java.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.java.dao.ERS_Ticket_DaoImpl;
import com.java.dao.ERS_User_DaoImpl;
import com.java.objects.ReimbursementTicket;

public class SubmitTicketController {
	public static String submit(HttpServletRequest req) {
		HttpSession s = req.getSession();
		ERS_Ticket_DaoImpl ticketDao = new ERS_Ticket_DaoImpl();
//		Set<ReimbursementTicket> allTickets = ticketDao.getAllTicketBasedOnUserID(
//				(new ERS_User_DaoImpl()).getUserWithLogin((String)s.getAttribute("username"),(String)s.getAttribute("password")).getUserRoleID());
		int reimb_type = 0;
		try{
			reimb_type = Integer.parseInt(req.getParameter("type"));
		}catch(NumberFormatException e) {
			System.out.println("Invalid type");
		}
		double reimb_amount = 0.0;
		try{
			reimb_amount = Double.parseDouble(req.getParameter("ticket-amount"));
		}catch(NumberFormatException e) {
			System.out.println("Invalid Amount");
		}
		String reimb_description = req.getParameter("ticket-description");
		
		System.out.println("3.1" + reimb_amount);
		System.out.println("3.2" + reimb_type);
		System.out.println("3.3" + reimb_description);
		ticketDao.insertNewTicket(reimb_amount, (int)s.getAttribute("userid"), reimb_type, reimb_description);
		System.out.println("Finished");
		return "index.html";
	}
}

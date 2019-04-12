package com.java.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.java.dao.ERS_Ticket_DaoImpl;
import com.java.objects.ERS_User;
import com.java.objects.ReimbursementTicket;

public class UserTicketController {
//	public static String
	private Gson gson = new Gson();

	public void getAllTicketsForUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        HttpSession s = req.getSession();

        int user_id = ((ERS_User)s.getAttribute("User")).getUserId();

		ERS_Ticket_DaoImpl ticket_db_conn = new ERS_Ticket_DaoImpl();
		Set<ReimbursementTicket> ticketList = ticket_db_conn.getAllTicketBasedOnUserID(user_id);

		String data = this.gson.toJson(ticketList);
		data = "{\"ticket\": " + data + "}";
		writer.print(data);
	}
	public void getAllPendingTicketForUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        HttpSession s = req.getSession(false);

        int user_id = ((ERS_User)s.getAttribute("User")).getUserId();

		ERS_Ticket_DaoImpl ticket_db_conn = new ERS_Ticket_DaoImpl();
		Set<ReimbursementTicket> ticketList = ticket_db_conn.getPendingTicketBasedOnUserID(user_id);
		for(ReimbursementTicket i: ticketList) {
			System.out.println(i.getTicketID());
		}
		String data = this.gson.toJson(ticketList);
		data = "{\"ticket\": " + data + "}";
		writer.print(data);
	}
	public void getAllResolvedTicketForUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        HttpSession s = req.getSession(false);

        int user_id = ((ERS_User)s.getAttribute("User")).getUserId();

		ERS_Ticket_DaoImpl ticket_db_conn = new ERS_Ticket_DaoImpl();
		Set<ReimbursementTicket> ticketList = ticket_db_conn.getResolvedTicketBasedOnUserID(user_id);

		String data = this.gson.toJson(ticketList);
		data = "{\"ticket\": " + data + "}";
		writer.print(data);
	}
	public void getAllPendingTickets(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        HttpSession s = req.getSession(false);

        int user_id = ((ERS_User)s.getAttribute("User")).getUserId();

		ERS_Ticket_DaoImpl ticket_db_conn = new ERS_Ticket_DaoImpl();
		Set<ReimbursementTicket> ticketList = ticket_db_conn.getPendingTicket();

		String data = this.gson.toJson(ticketList);
		data = "{\"ticket\": " + data + "}";
		writer.print(data);
		
	}
}

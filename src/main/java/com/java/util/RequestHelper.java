package com.java.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.java.controller.LoginController;
import com.java.controller.ManagerTicketController;
import com.java.controller.SubmitTicketController;
import com.java.controller.UserTicketController;
import com.java.dao.ERS_Ticket_DaoImpl;
import com.java.objects.ERS_User;
import com.java.objects.ReimbursementTicket;

public class RequestHelper {
	private static Gson gson = new Gson();

	public static String process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("1" + req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/ExpenseReimbursementSystem/validate.do":
			return LoginController.login(req);
		case "/ExpenseReimbursementSystem/create-new-request.do":
			return "create-ticket.html";
		case "/ExpenseReimbursementSystem/create-new-request-manager.do":
			return "create-ticket-manager.html";
		case "/ExpenseReimbursementSystem/submit.do":
			return SubmitTicketController.submit(req);
		case "/ExpenseReimbursementSystem/approve-deny.do":
			return "pending-ticket.do";
		case "/ExpenseReimbursementSystem/goHome.do":
			return LoginController.goHome(req);
		case "/ExpenseReimbursementSystem/resolve.do":
			return ManagerTicketController.resolve(req);
		case "/ExpenseReimbursementSystem/logout.do":
			req.getSession().invalidate();
		default:
			return "index.html";
		}
	}

	public static void process_2(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("2" + req.getRequestURI());
		UserTicketController controllerUser = new UserTicketController();
		switch (req.getRequestURI()) {
		case "/ExpenseReimbursementSystem/getTicket.change":
			controllerUser.getAllTicketsForUser(req, resp); break;
		case "/ExpenseReimbursementSystem/getPending.change":
			controllerUser.getAllPendingTicketForUser(req, resp); break;
		case "/ExpenseReimbursementSystem/getResolved.change":
			controllerUser.getAllResolvedTicketForUser(req, resp); break;
		case "/ExpenseReimbursementSystem/getAllPending.change":
			controllerUser.getAllPendingTickets(req, resp); break;
		}
	}

}

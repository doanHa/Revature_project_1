package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dao.ERS_Ticket_DaoImpl;
import com.java.objects.ERS_User;
import com.java.objects.ReimbursementTicket;
import com.java.util.RequestHelper;
import com.google.gson.Gson;
public class TicketTableServlet  extends HttpServlet{
	private Gson gson = new Gson();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("We are here 3");
		RequestHelper.process_2(req, resp);
	}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("We are here 4");
        RequestHelper.process_2(req, resp);
    }
}

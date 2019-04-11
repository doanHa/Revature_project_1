package com.java.objects;

import java.sql.Date;

public class ReimbursementTicket {
	private int ticketID, authorID, resolverID, ticketStatus, ticketType;
	private double reimbursementAmount;
	private Date submittedDate, resolvedDate;
	private String ticketDescription;

	ReimbursementTicket(int ticket_id, int author_id, double reimbursement_amount, Date submitted_date,
			Date resolved_date, String description, int resolver_id, int status, int type) {
		ticketID = ticket_id;
		authorID = author_id;
		reimbursementAmount = reimbursement_amount;
		submittedDate = submitted_date;
		resolvedDate = resolved_date;
		ticketDescription = description;
		resolverID = resolver_id;
		ticketStatus = status;
		ticketType = type;
	}

	ReimbursementTicket(int ticket_id, int author_id, double reimbursement_amount, Date submitted_date,
			String description, int resolver_id, int status, int type) {
		ticketID = ticket_id;
		authorID = author_id;
		reimbursementAmount = reimbursement_amount;
		submittedDate = submitted_date;
		ticketDescription = description;
		resolverID = resolver_id;
		ticketStatus = status;
		ticketType = type;
	}

	public ReimbursementTicket() {
	}

	public void setTicketID(int ticket_id) {
		ticketID = ticket_id;
	}

	public void setAuthorID(int author_id) {
		authorID = author_id;
	}

	public void setResolverID(int resolver_id) {
		resolverID = resolver_id;
	}

	public void setTicketStatus(int ticket_status) {
		ticketStatus = ticket_status;
	}

	public void setTicketType(int ticket_type) {
		ticketType = ticket_type;
	}

	void setTicketDescription(String description) {
		ticketDescription = description;
	}

	public void setReimbursementAmount(double amount) {
		reimbursementAmount = amount;
	}

	public void setSubmittedDate(Date submitted_date) {
		submittedDate = submitted_date;
	}

	public void setResolvedDate(Date resolved_date) {
		resolvedDate = resolved_date;
	}

	public int getTicketID() {
		return ticketID;
	}

	public int getAuthorID() {
		return authorID;
	}

	public int getResolverID() {
		return resolverID;
	}

	public int getTicketStatus() {
		return ticketStatus;
	}

	public int getTicketType() {
		return ticketType;
	}
	public String getTicketDescription() {
		return ticketDescription;
	}
	public double getReimbursementAmount() {
		return reimbursementAmount;
	}
	public Date getSubmittedDate() {
		return submittedDate;
	}
	public Date getResolvedDate() {
		return resolvedDate;
	}
}

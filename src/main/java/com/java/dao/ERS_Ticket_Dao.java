package com.java.dao;

import java.util.Set;

import com.java.objects.ReimbursementTicket;

public interface ERS_Ticket_Dao {
	Set<ReimbursementTicket> getAllTicket();
	ReimbursementTicket getTicket();
}

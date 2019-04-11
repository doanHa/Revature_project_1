package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.java.objects.ReimbursementTicket;
import com.java.util.DBUtil;

public class ERS_Ticket_DaoImpl implements ERS_Ticket_Dao {
	private Connection con;

	public Set<ReimbursementTicket> getAllTicket() {
		con = DBUtil.getInstance();
		Set<ReimbursementTicket> allTickets = new HashSet<ReimbursementTicket>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from ers_reimbursement");
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				ReimbursementTicket temp = extractTicketData(result);
				allTickets.add(temp);
			}
		} catch (SQLException e) {
			System.out.println("Unable to connect! Please try again");
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
		}
		return null;
	}

	public ReimbursementTicket getTicket() {
//		con = DBUtil.getInstance();
//		ReimbursementTicket ticket = null;
//		try {
//			PreparedStatement ps = con.prepareStatement("select * from ers_reimbursement");
//			ResultSet result = ps.executeQuery();
//			if (result.next()) {
//				ticket = extractTicketData(result);
//			}
//		} catch (SQLException e) {
//			System.out.println("Unable to connect! Please try again");
//		} finally {
//			if (con != null)
//				try {
//					con.close();
//				} catch (SQLException e) {
//					/* ignored */}
//		}
		return null;
	}
	public Set<ReimbursementTicket> getPendingTicket(){
		con = DBUtil.getInstance();
		Set<ReimbursementTicket> pendingTicket = new HashSet<ReimbursementTicket>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from ers_reimbursement where reimb_status_id = 1");
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				pendingTicket.add(extractTicketData(result));
			}
		}catch(SQLException e) {
			System.out.println("Unable to connect! Please try again");
		}finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
		}
		
		return pendingTicket;
		
	}
	public Set<ReimbursementTicket> getApprovedTicket(){
		con = DBUtil.getInstance();
		Set<ReimbursementTicket> approvedTicket = new HashSet<ReimbursementTicket>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from ers_reimbursement where reimb_status_id=2");
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				approvedTicket.add(extractTicketData(result));
			}
		}catch(SQLException e) {
			System.out.println("Unable to connect! Please try again");
		}finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
		}
		
		return approvedTicket;
		
	}
	public Set<ReimbursementTicket> getDeniedTicket(){
		con = DBUtil.getInstance();
		Set<ReimbursementTicket> deniedTicket = new HashSet<ReimbursementTicket>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from ers_reimbursement where reimb_status_id=3");
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				deniedTicket.add(extractTicketData(result));
			}
		}catch(SQLException e) {
			System.out.println("Unable to connect! Please try again");
		}finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
		}
		
		return deniedTicket;
		
	}
	public Set<ReimbursementTicket> getAllTicketBasedOnUserID(int userID){
		con = DBUtil.getInstance();
		Set<ReimbursementTicket> userTickets = new HashSet<ReimbursementTicket>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from ers_reimbursement where reimb_author=?");
			ps.setInt(1, userID);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				userTickets.add(extractTicketData(result));
			}
		}catch(SQLException e) {
			System.out.println("Unable to connect! Please try again");
		}finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
		}
		
		return userTickets;
	}
	public int insertNewTicket(double amount, int userID, int ticket_type, String ticket_description) {
		con=DBUtil.getInstance();
		int numRowInserted = 0;
		try {
			PreparedStatement ps = con.prepareStatement("insert into ers_reimbursement (reimb_amount, reimb_author, reimb_type_id, reimb_description) values (?, ?, ?, ?)");
			ps.setDouble(1, amount);
			ps.setInt(2, userID);
			ps.setInt(3, ticket_type);
			ps.setString(4, ticket_description);

			numRowInserted = ps.executeUpdate();

			con.commit();

		}catch(SQLException e) {
			System.out.println("Unable to connect! Please try again");
		}finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					/* ignored */}
		}
		return numRowInserted;
		
	}
	public int updateApproval(int ticket_id, int resolver_id, int status_id) {
		con = DBUtil.getInstance();
		int numRowUpdate = 0;
		try {
			PreparedStatement ps_1 = con.prepareStatement("update ers_reimbursement set reimb_resolver=?, reimb_resolved=sysdate, reimb_status_id=? where reimb_id=?");

			ps_1.setInt(1, resolver_id);
			ps_1.setInt(2, status_id);
			ps_1.setInt(3, ticket_id);
			
		}catch(SQLException e) {
			System.out.println("Unable to connect! Please try again");
		}
		
		return numRowUpdate;
	}
	private ReimbursementTicket extractTicketData(ResultSet rs) {
		return null;
	}

}

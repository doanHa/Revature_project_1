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
		return allTickets;
	}

	public Set<ReimbursementTicket> getPendingTicket() {
		con = DBUtil.getInstance();
		Set<ReimbursementTicket> pendingTicket = new HashSet<ReimbursementTicket>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from ers_reimbursement where reimb_status_id = 1");
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				pendingTicket.add(extractTicketData(result));
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

		return pendingTicket;

	}

	public Set<ReimbursementTicket> getApprovedTicket() {
		con = DBUtil.getInstance();
		Set<ReimbursementTicket> approvedTicket = new HashSet<ReimbursementTicket>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from ers_reimbursement where reimb_status_id=2");
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				approvedTicket.add(extractTicketData(result));
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

		return approvedTicket;

	}

	public Set<ReimbursementTicket> getDeniedTicket() {
		con = DBUtil.getInstance();
		Set<ReimbursementTicket> deniedTicket = new HashSet<ReimbursementTicket>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from ers_reimbursement where reimb_status_id=3");
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				deniedTicket.add(extractTicketData(result));
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

		return deniedTicket;

	}

	public Set<ReimbursementTicket> getAllTicketBasedOnUserID(int userID) {
		con = DBUtil.getInstance();
		Set<ReimbursementTicket> userTickets = new HashSet<ReimbursementTicket>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from ers_reimbursement where reimb_author=?");
			ps.setInt(1, userID);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				userTickets.add(extractTicketData(result));
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

		return userTickets;
	}

	public Set<ReimbursementTicket> getDeniedTicketBasedOnUserID(int user_id) {
		con = DBUtil.getInstance();
		Set<ReimbursementTicket> deniedTicket = new HashSet<ReimbursementTicket>();
		try {
			PreparedStatement ps = con
					.prepareStatement("select * from ers_reimbursement where reimb_status_id=3 and reimb_author=?");
			ps.setInt(1, user_id);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				deniedTicket.add(extractTicketData(result));
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

		return deniedTicket;

	}

	public Set<ReimbursementTicket> getApprovedTicketBasedOnUserID(int user_id) {
		con = DBUtil.getInstance();
		Set<ReimbursementTicket> approvedTickets = new HashSet<ReimbursementTicket>();
		try {
			PreparedStatement ps = con
					.prepareStatement("select * from ers_reimbursement where reimb_status_id=2 and reimb_author=?");
			ps.setInt(1, user_id);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				approvedTickets.add(extractTicketData(result));
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

		return approvedTickets;

	}

	public Set<ReimbursementTicket> getPendingTicketBasedOnUserID(int user_id) {
		con = DBUtil.getInstance();
		Set<ReimbursementTicket> pendingTickets = new HashSet<ReimbursementTicket>();
		System.out.println("We are here 5");
		try {
			PreparedStatement ps = con
					.prepareStatement("select * from ers_reimbursement where reimb_status_id=1 and reimb_author=?");
			ps.setInt(1, user_id);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				pendingTickets.add(extractTicketData(result));
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

		return pendingTickets;

	}
	public Set<ReimbursementTicket> getResolvedTicketBasedOnUserID(int user_id) {
		con = DBUtil.getInstance();
		Set<ReimbursementTicket> pendingTickets = new HashSet<ReimbursementTicket>();
		System.out.println("We are here 5");
		try {
			PreparedStatement ps = con
					.prepareStatement("select * from ers_reimbursement where reimb_status_id in (2,3) and reimb_author=?");
			ps.setInt(1, user_id);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				pendingTickets.add(extractTicketData(result));
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

		return pendingTickets;

	}


	public int insertNewTicket(double amount, int userID, int ticket_type, String ticket_description) {
		con = DBUtil.getInstance();
		int numRowInserted = 0;
		try {
			PreparedStatement ps = con.prepareStatement(
					"insert into ers_reimbursement (reimb_amount, reimb_author, reimb_type_id, reimb_description) values (?, ?, ?, ?)");
			ps.setDouble(1, amount);
			ps.setInt(2, userID);
			ps.setInt(3, ticket_type);
			ps.setString(4, ticket_description);

			numRowInserted = ps.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			System.out.println("Unable to connect! Please try again");
		} finally {
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
			PreparedStatement ps_1 = con.prepareStatement(
					"update ers_reimbursement set reimb_resolver=?, reimb_resolved=sysdate, reimb_status_id=? where reimb_id=?");

			ps_1.setInt(1, resolver_id);
			ps_1.setInt(2, status_id);
			ps_1.setInt(3, ticket_id);
			ps_1.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			System.out.println("Unable to connect! Please try again");
		}

		return numRowUpdate;
	}

	private ReimbursementTicket extractTicketData(ResultSet rs) {
		ReimbursementTicket ticket = null;
		try {
			ticket = new ReimbursementTicket();
			ticket.setTicketID(rs.getInt(1));
			ticket.setReimbursementAmount(rs.getDouble(2));
			ticket.setSubmittedDate(rs.getDate(3));
			ticket.setResolvedDate(rs.getDate(4));
			ticket.setTicketDescription(rs.getString(5));
			ticket.setAuthorID(rs.getInt(7));
			ticket.setResolverID(rs.getInt(8));
			ticket.setTicketStatus(rs.getInt(9));
			ticket.setTicketType(rs.getInt(10));
		} catch (SQLException sqlE) {
			System.out.println("Database error!");
		} catch (NumberFormatException numFE) {
			System.out.println("Error parsing data");
		}
		return ticket;
	}

}

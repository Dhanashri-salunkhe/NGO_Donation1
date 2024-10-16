package com.yash.DAOImpl;

import com.yash.DAO.DonationDAO;
import com.yash.JDBCutil.*;
import com.yash.POJO.Donation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonationDAOImpl implements DonationDAO {
    private JDBCUtil jdbcUtil;

    public DonationDAOImpl(JDBCUtil jdbcUtil) {
        this.jdbcUtil = jdbcUtil;
    }

    public List<Donation> getAllDonations() {
        List<Donation> donations = new ArrayList<>();
        String query = "SELECT * FROM donations";
        Connection conn = jdbcUtil.getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Donation donation = new Donation();
                donation.setDonationId(rs.getInt("donation_id"));
                donation.setAmount(rs.getDouble("amount"));
                donation.setDonorName(rs.getString("donor_name"));
                donation.setDonationDate(rs.getString("donation_date"));
                donations.add(donation);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtil.closeConnection(conn);
        }
        return donations;
    }

    @Override
    public Donation getDonationById(int donationId) {
        Donation donation = null;
        String query = "SELECT * FROM donations WHERE donation_id = ?";
        Connection conn = jdbcUtil.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, donationId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    donation = new Donation();
                    donation.setDonationId(rs.getInt("donation_id"));
                    donation.setAmount(rs.getDouble("amount"));
                    donation.setDonorName(rs.getString("donor_name"));
                    donation.setDonationDate(rs.getString("donation_date"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtil.closeConnection(conn);
        }
        return donation;
    }

    public void addDonation(Donation donation) {
        String query = "INSERT INTO donations (amount, donor_name, donation_date) VALUES (?, ?, ?)";
        Connection conn = jdbcUtil.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDouble(1, donation.getDonationAmount());
     
            pstmt.setString(3, donation.getDonationDate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtil.closeConnection(conn);
        }
    }

    public void updateDonation(Donation donation) {
        String query = "UPDATE donations SET amount = ?, donor_name = ?, donation_date = ? WHERE donation_id = ?";
        Connection conn = jdbcUtil.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDouble(1, donation.getDonationAmount());
            //pstmt.setString(2, donation.getDonorName());
            pstmt.setString(3, donation.getDonationDate());
            pstmt.setInt(4, donation.getDonationId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtil.closeConnection(conn);
        }
    }

    public void deleteDonation(int donationId) {
        String query = "DELETE FROM donations WHERE donation_id = ?";
        Connection conn = jdbcUtil.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, donationId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtil.closeConnection(conn);
        }
    }

	@Override
	public List<Donation> getAllCampaigns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Donation getCampaignById(int DonationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCampaign(Donation donation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCampaign(Donation donation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCampaign(int donationId) {
		// TODO Auto-generated method stub
		
	}
}
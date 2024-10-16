package com.yash.service.impl;

import com.yash.DAO.DonationDAO;
import com.yash.DAOImpl.DonationDAOImpl;
 import com.yash.POJO.Donation;
import com.yash.service.DonationService;

import java.util.List;

public class DonationServiceImpl implements DonationService {
    private DonationDAO donationDAO;

    public DonationServiceImpl() {
        this.donationDAO = new DonationDAOImpl(null);
    }

    @Override
    public List<Donation> getAllDonations() {
        return ((DonationDAOImpl) donationDAO).getAllDonations();
    }

    @Override
    public Donation getCampaignById(int donationId) {
        return donationDAO.getDonationById(donationId);
    }

    @Override
    public void addDonation(Donation donation) {
        ((DonationDAOImpl) donationDAO).addDonation(donation);
    }

    @Override
    public void updateDonation(Donation donation) {
        ((DonationDAOImpl) donationDAO).updateDonation(donation);
    }

    @Override
    public void deleteDonation(int donationId) {
        ((DonationDAOImpl) donationDAO).deleteDonation(donationId);
    }

	@Override
	public Donation getDonationById(int donationId) {
		// TODO Auto-generated method stub
		return null;
	}
}
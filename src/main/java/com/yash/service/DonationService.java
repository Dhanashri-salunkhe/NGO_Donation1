package com.yash.service;

import com.yash.POJO.*;


import java.util.List;

public interface DonationService 
{
    List<Donation> getAllDonations();
    Donation getCampaignById(int donationId);
    void addDonation(Donation donation);
    void updateDonation(Donation donation);
    void deleteDonation(int donationId);
	Donation getDonationById(int donationId);
}
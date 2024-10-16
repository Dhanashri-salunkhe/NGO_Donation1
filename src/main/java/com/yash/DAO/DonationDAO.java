package com.yash.DAO;

import java.util.*;

import com.yash.POJO.Donation;

public interface DonationDAO 
{
	List<Donation> getAllCampaigns();
    Donation getCampaignById(int DonationId);
    void addCampaign(Donation donation);
    void updateCampaign(Donation donation);
    void deleteCampaign(int donationId);
	Donation getDonationById(int donationId);
}
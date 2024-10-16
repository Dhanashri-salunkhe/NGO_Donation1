package com.yash.controller;

import com.yash.POJO.Donation; 
import com.yash.service.DonationService;
import com.yash.service.impl.DonationServiceImpl;

import java.util.List;

public class DonationController {
    private DonationService donationService;

    public DonationController() {
        donationService = new DonationServiceImpl();
    }

    public List<Donation> getAllDonations() {
        return donationService.getAllDonations();
    }

    public Donation getDonationById(int donationId) {
        return donationService.getDonationById(donationId);
    }

    public void addDonation(Donation donation) {
        donationService.addDonation(donation);
    }

    public void updateDonation(Donation donation) {
        donationService.updateDonation(donation);
    }

    public void deleteDonation(int donationId) {
        donationService.deleteDonation(donationId);
    }
}
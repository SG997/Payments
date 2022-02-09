package com.app.services;

import com.app.dao.Payments;
import com.app.repo.PaymentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentsRepo paymentsRepo;


    public void payForUserFee(String from, String to, double amount, long timeStamp){
        Payments payments = new Payments(from, to, amount, timeStamp);

        // Save in the DB
        this.paymentsRepo.save(payments);

        // Inform the User service about the payment


        // Notify User service

    }


}
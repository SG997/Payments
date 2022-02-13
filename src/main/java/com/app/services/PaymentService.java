package com.app.services;

import com.app.Utils;
import com.app.config.system_data.UserDetailsAuth;
import com.app.dao.PendingTransaction;
import com.app.data.RequestUrlForPaymentData;
import com.app.data.meshulam.CreatePaymentProcess;
import com.app.repo.PendingTransactionRepo;
import com.app.rest.RestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;

@Service
public class PaymentService {

    @Autowired
    PendingTransactionRepo pendingTransactionRepo;

    @Autowired
    RestAPI restAPI;




    public String generateUrlForPayment(UserDetailsAuth userDetailsAuth, RequestUrlForPaymentData requestData){

        String userId = userDetailsAuth.getIsraeliIdNumber();
        String fullName = userDetailsAuth.getName() + " " + userDetailsAuth.getLastName();
        String phoneNumber = userDetailsAuth.getSuffix();

        // Generate url for payment
        CreatePaymentProcess createPaymentProcess = restAPI.createPaymentProcess(requestData.getPaymentMethod(), requestData.getSum(), fullName, phoneNumber);

        // TODO save status pending for payment in the db
        String time = Utils.getFormattedDate(Calendar.getInstance().getTime());
        PendingTransaction pendingTransaction = new PendingTransaction(userId, "System", requestData.getSum(), time, requestData.getPaymentMethod(), requestData.getPaymentType());

        this.pendingTransactionRepo.save(pendingTransaction);

        return createPaymentProcess.getData().getUrl();
    }

    public void payForUserFee(String from, String to, double amount, long timeStamp){
        /*Payments payments = new Payments(from, to, amount, timeStamp);

        // Save in the DB
        this.paymentsRepo.save(payments);*/

        // Inform the User service about the payment


        // Notify User service

    }


}
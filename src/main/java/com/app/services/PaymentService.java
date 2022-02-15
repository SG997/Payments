package com.app.services;

import com.app.Utils;
import com.app.config.system_data.UserDetailsAuth;
import com.app.dao.Payments;
import com.app.dao.PendingTransaction;
import com.app.data.ReportPayment;
import com.app.data.RequestUrlForPaymentData;
import com.app.data.meshulam.CreatePaymentProcess;
import com.app.data.responses.GenerateUrlResponse;
import com.app.marketing.DealsType;
import com.app.repo.PaymentsRepo;
import com.app.repo.PendingTransactionRepo;
import com.app.rest.RestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    PendingTransactionRepo pendingTransactionRepo;

    @Autowired
    PaymentsRepo paymentsRepo;

    @Autowired
    RestAPI restAPI;

    final String SYSTEM_ID = "SYSTEM";




    public GenerateUrlResponse generateUrlForPayment(UserDetailsAuth userDetailsAuth, RequestUrlForPaymentData requestData){

        String userId = userDetailsAuth.getIsraeliIdNumber();
        String fullName = userDetailsAuth.getName() + " " + userDetailsAuth.getLastName();
        String phoneNumber = userDetailsAuth.getSuffix();

        // Generate url for payment
        CreatePaymentProcess createPaymentProcess = restAPI.createPaymentProcess(requestData.getPaymentMethod(), requestData.getDealType().value, fullName, phoneNumber);

        // TODO save status pending for payment in the db
        String time = Utils.getFormattedDate(Calendar.getInstance().getTime());
        PendingTransaction pendingTransaction = new PendingTransaction(userId, SYSTEM_ID, requestData.getDealType().value, time, requestData.getPaymentMethod(), requestData.getDealType(), createPaymentProcess.getData().getProcessId() + "");

        this.pendingTransactionRepo.save(pendingTransaction);

        return new GenerateUrlResponse(createPaymentProcess.getData().getUrl(), pendingTransaction.getProcessId());
    }

    public void payForUserFee(String israeliIdNumber, ReportPayment paymentReport){

        // Check if it available from what it suppose to be in Cache
        Optional<PendingTransaction> optPending = this.pendingTransactionRepo.findByProcessId(paymentReport.getProcessId());

        String time = Utils.getFormattedDate(new Date(paymentReport.getTimestamp()));
        DealsType dealType;
        boolean isFoundInCache;
        if (optPending.isEmpty()) {

            // TODO handle in case of system doesn't remember it
            isFoundInCache = false;
            // So we can let the user continue working
            dealType = DealsType.MONTHLY;

        } else {

            dealType = optPending.get().getDealType();
            isFoundInCache = true;

        }



        Payments payment = new Payments(israeliIdNumber, SYSTEM_ID, paymentReport.getAmount(), time, paymentReport.getPaymentMethod(), dealType, isFoundInCache);

        this.paymentsRepo.save(payment);

        // TODO Notify User service

    }
    
}
package com.app.controller;

import com.app.config.system_data.UserDetailsAuth;
import com.app.dao.Payments;
import com.app.data.ReportPayment;
import com.app.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("payments")
@RestController
public class PaymentsController {

    @Autowired
    private PaymentService paymentsService;

    @PostMapping("payForUserFee")
    public ResponseEntity<?> payForUserFee(@RequestBody ReportPayment paymentReport){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() != null) {
            UserDetailsAuth userDetailsAuth = (UserDetailsAuth) authentication.getPrincipal();


            this.paymentsService.payForUserFee(userDetailsAuth.getIsraeliIdNumber(), paymentReport.getPayingFor(),paymentReport.getAmount(), paymentReport.getTimestamp());

            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}

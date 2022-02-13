package com.app.controller;

import com.app.config.system_data.AuthenticationResponse;
import com.app.config.system_data.UserDetailsAuth;
import com.app.data.PaymentMethod;
import com.app.data.PaymentType;
import com.app.data.ReportPayment;
import com.app.data.RequestUrlForPaymentData;
import com.app.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RequestMapping("payments")
@RestController
public class PaymentsController {

    @Autowired
    private PaymentService paymentsService;

    @PostMapping("/payForUserFee")
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

    @PutMapping("/payment")
    public ResponseEntity<?> getPayment(@RequestBody RequestUrlForPaymentData requestData) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() != null) {
            UserDetailsAuth userDetailsAuth = ((AuthenticationResponse) authentication.getPrincipal()).getUserDetailsAuth();

            if (requestData.getPaymentType() != PaymentType.MONTHLY_USE && requestData.getPaymentType() != PaymentType.YEARLY_USE){
                return ResponseEntity.badRequest().body("Wrong use of this methods, please try diffrent payment method");
            }

            String url = this.paymentsService.generateUrlForPayment(userDetailsAuth, requestData);

            return ResponseEntity.ok().body(url);
        }

        return ResponseEntity.badRequest().build();
    }
}
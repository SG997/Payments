package com.app.controller;

import com.app.config.system_data.AuthenticationResponse;
import com.app.config.system_data.UserDetailsAuth;
import com.app.data.ReportPayment;
import com.app.data.RequestUrlForPaymentData;
import com.app.data.responses.GenerateUrlResponse;
import com.app.marketing.DealsType;
import com.app.services.PaymentService;
import io.swagger.v3.oas.annotations.headers.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


@RequestMapping("payments")
@RestController
public class PaymentsController {

    @Autowired
    private PaymentService paymentsService;

    @PostMapping("/payForUserFee")
    public ResponseEntity<?> payForUserFee(@RequestBody ReportPayment paymentReport, @RequestHeader(name = AUTHORIZATION) String header) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() != null) {
            UserDetailsAuth userDetailsAuth = ((AuthenticationResponse) authentication.getPrincipal()).getUserDetailsAuth();


            this.paymentsService.payForUserFee(header, userDetailsAuth.getIsraeliIdNumber(), paymentReport);

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

            if (requestData.getDealType() != DealsType.MONTHLY && requestData.getDealType() != DealsType.YEARLY){
                return ResponseEntity.badRequest().body("Wrong use of this methods, please try diffrent payment method");
            }

            GenerateUrlResponse generateUrlForPayment = this.paymentsService.generateUrlForPayment(userDetailsAuth, requestData);

            return ResponseEntity.ok().body(generateUrlForPayment);
        }

        return ResponseEntity.badRequest().build();
    }
}
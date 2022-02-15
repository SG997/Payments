package com.app.rest;

import com.app.Exception.DataNotSaveInDb;
import com.app.data.PaymentMethod;
import com.app.data.meshulam.CreatePaymentProcess;
import com.app.marketing.data.DealsPack;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
public class RestAPI {

    private final String url = "http://localhost:8065/user/getPersonalDetails";
    private final String urlExpandsUserValidity = "http://localhost:8065/userRelated/notifyPayment";


    private final String INTERNATIONAL_ISRAELI_PREFIX = "+972";

    public void expandForReceivePayment(String header, DealsPack expandsTime) throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, " " + header);






        // Request url TODO inject it

        RestTemplate restTemplate = new RestTemplate();


        HttpEntity<DealsPack> request = new HttpEntity<>(expandsTime, headers);

        // Execute the request
        ResponseEntity<String> response = restTemplate.postForEntity(urlExpandsUserValidity, request , String.class);

        // TODO save the full Json text in logs for future testing

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new DataNotSaveInDb();
        }


    }


    public CreatePaymentProcess createPaymentProcess(PaymentMethod paymentMethod, double sum, String fullName, String fullPhoneNumber){

        // Request url TODO inject it
        String url = "https://sandbox.meshulam.co.il/api/light/server/1.0/createPaymentProcess";

        RestTemplate restTemplate = new RestTemplate();

        // Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.add("Cookie", "PHPSESSID=f8311aec6534bbf9629d86fbf480b390");
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // FormData
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        //map.add("pageCode", "448b3c623ba3");
        map.add("userId", "0a9b82a404a2bb73");
        map.add("pageCode", "448b3c623ba3");
        map.add("sum", sum + "");
        map.add("pageField[fullName]", fullName);
        map.add("pageField[phone]", fullPhoneNumber);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        // Execute the request
        ResponseEntity<String> response = restTemplate.postForEntity(url, request , String.class);

        // TODO save the full Json text in logs for future testing
        // Let's parse the mother fuck it so The company will can get $$$$$$$$$, ₪₪₪₪₪
        JsonObject jsonObject = new Gson().fromJson(response.getBody(), JsonObject.class);
        Gson gson= new Gson();
        CreatePaymentProcess obj = gson.fromJson(jsonObject.toString(), CreatePaymentProcess.class);

        return obj;
    }
}

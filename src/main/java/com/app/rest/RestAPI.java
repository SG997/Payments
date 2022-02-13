package com.app.rest;

import com.app.data.PaymentMethod;
import com.app.data.meshulam.CreatePaymentProcess;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
public class RestAPI {

    private final String url = "http://localhost:8065/user/getPersonalDetails";

    private final String INTERNATIONAL_ISRAELI_PREFIX = "+972";

    public void UpdateForReceivePayment(String header, List<String> ids){

        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, header);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity<List<String>> request = new HttpEntity<List<String>>(ids, headers);

        //RelatedAuthResponse relatedAuthResponse = restTemplate.postForObject(url, request, RelatedAuthResponse.class);

        //return relatedAuthResponse;
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

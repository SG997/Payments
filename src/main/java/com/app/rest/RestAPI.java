package com.app.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
public class RestAPI {

    private final String url = "http://localhost:8065/user/getPersonalDetails";

    public void UpdateForReceivePayment(String header, List<String> ids){

        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, header);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity<List<String>> request = new HttpEntity<List<String>>(ids, headers);

        //RelatedAuthResponse relatedAuthResponse = restTemplate.postForObject(url, request, RelatedAuthResponse.class);

        //return relatedAuthResponse;

    }



}

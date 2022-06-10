package com.app.config.filter;


import com.app.config.BeansNames;
import com.app.config.system_data.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component(BeansNames.ONCE_PER_REQUEST_FILTER)
public class Filter extends OncePerRequestFilter {

    final String BEARER = "Bearer ";
    final String AUTHORIZATION = "Authorization";

    @Value("${spring.url}")
    String baseUrl;

    private String url = "http://localhost:8065/user/token";


    @Autowired
    AuthenticationManager authenticationManager;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {


        final String requestTokenHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (requestTokenHeader != null && requestTokenHeader.startsWith(BEARER)) {


            HttpHeaders headers = new HttpHeaders();
            headers.add(this.AUTHORIZATION, " " + requestTokenHeader);



            HttpEntity<AuthenticationResponse> requestEntity = new HttpEntity<>(headers);

            url = baseUrl + "/user/token";


            ResponseEntity<AuthenticationResponse> request33 = new RestTemplate().exchange(
                    url, HttpMethod.GET, requestEntity, AuthenticationResponse.class);



            if(request33.getBody() != null && request33.getStatusCode() == HttpStatus.OK) {
                AuthenticationResponse body = request33.getBody();
                @SuppressWarnings("ConstantConditions") //body cannot be null on this stage
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        body, null, null);

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }


        }


        System.out.println("Hello Filter2");

        filterChain.doFilter(request, httpServletResponse);

    }
}
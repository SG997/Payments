package com.app.config.system_data;

import lombok.Builder;

import java.io.Serializable;


@Builder
public class AuthenticationResponse implements Serializable {
    UserDetailsAuth userDetailsAuth;
    String token;

    public AuthenticationResponse(){

    }

    public AuthenticationResponse(UserDetailsAuth userDetailsAuth, String token) {
        this.userDetailsAuth = userDetailsAuth;
        this.token = token;
    }

    public UserDetailsAuth getUserDetailsAuth() {
        return userDetailsAuth;
    }

    public void setUserDetailsAuth(UserDetailsAuth userDetailsAuth) {
        this.userDetailsAuth = userDetailsAuth;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

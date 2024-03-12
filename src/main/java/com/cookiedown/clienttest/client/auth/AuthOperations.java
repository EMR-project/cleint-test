package com.cookiedown.clienttest.client.auth;

import com.cookiedown.clienttest.dto.JoinRequest;
import com.cookiedown.clienttest.dto.JoinResponse;
import com.cookiedown.clienttest.dto.LoginRequest;
import com.cookiedown.clienttest.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.reactive.function.client.WebClient;

public class AuthOperations implements AuthApi {

    private final WebClient client;

    public AuthOperations(@Qualifier("authClient") WebClient authClient) {
        this.client = authClient;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        return this.client.post()
                .uri(AuthUri.LOGIN)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(LoginResponse.class)
                .block();
    }

    @Override
    public JoinResponse join(JoinRequest request) {
        return this.client.post()
                .uri(AuthUri.JOIN)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(JoinResponse.class)
                .block();
    }

}

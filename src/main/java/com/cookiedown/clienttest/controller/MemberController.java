package com.cookiedown.clienttest.controller;

import com.cookiedown.clienttest.client.AuthApi;
import com.cookiedown.clienttest.dto.LoginRequest;
import com.cookiedown.clienttest.dto.LoginResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/member")
@RestController
public class MemberController {

    private final AuthApi authApi;

    MemberController(AuthApi authApi) {
        this.authApi = authApi;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return this.authApi.login(request);
    }

}

package com.cookiedown.clienttest.client;

import com.cookiedown.clienttest.dto.JoinRequest;
import com.cookiedown.clienttest.dto.JoinResponse;
import com.cookiedown.clienttest.dto.LoginRequest;
import com.cookiedown.clienttest.dto.LoginResponse;

public interface AuthApi {

    LoginResponse login(LoginRequest request);

    JoinResponse join(JoinRequest request);

}

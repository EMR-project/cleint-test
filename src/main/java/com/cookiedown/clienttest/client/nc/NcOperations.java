package com.cookiedown.clienttest.client.nc;

import com.cookiedown.clienttest.client.auth.AuthUri;
import com.cookiedown.clienttest.config.WebClientProperties;
import com.cookiedown.clienttest.dto.*;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public class NcOperations implements NcApi {

    private final WebClient client;

    public NcOperations(@Qualifier("ncClient") WebClient ncClient) {
        this.client = ncClient;
    }

    @Override
    public List<WorldInfoResponse> getInfo() {
        return this.client.get()
                .uri(NcUri.GET_WORLDINFO)
                .retrieve()
                .bodyToFlux(WorldInfoResponse.class)
                .collectList()
                .block();
    }
}

package com.cookiedown.clienttest.client.nc;

import com.cookiedown.clienttest.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Slf4j
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

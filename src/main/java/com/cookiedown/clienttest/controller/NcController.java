package com.cookiedown.clienttest.controller;

import com.cookiedown.clienttest.client.auth.AuthApi;
import com.cookiedown.clienttest.client.nc.NcApi;
import com.cookiedown.clienttest.dto.ContentsResponse;
import com.cookiedown.clienttest.dto.LoginRequest;
import com.cookiedown.clienttest.dto.LoginResponse;
import com.cookiedown.clienttest.dto.WorldInfoResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/nc")
@RestController

public class NcController {
    private final NcApi ncApi;

    NcController(NcApi ncApi) {
        this.ncApi = ncApi;
    }

    @GetMapping("/world-info")
    public List<WorldInfoResponse> getWorldInfo() {
        return this.ncApi.getInfo();
    }

    @GetMapping("/item-search-info")
    public ContentsResponse getItemSearchInfo() {
        return this.ncApi.getItemInfo();
    }

}

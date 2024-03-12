package com.cookiedown.clienttest.client.nc;

import com.cookiedown.clienttest.dto.*;

import java.util.List;

public interface NcApi {

    List<WorldInfoResponse> getInfo();
    ContentsResponse getItemInfo();

}

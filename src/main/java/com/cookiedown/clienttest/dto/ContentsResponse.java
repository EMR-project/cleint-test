package com.cookiedown.clienttest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ContentsResponse {
    private List<ItemSearchResponse> contents;
    private PaginationResponse pagination;
}

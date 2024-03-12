package com.cookiedown.clienttest.dto;

import lombok.Getter;
import lombok.Setter;

public record PaginationResponse(Integer page, Integer size, Integer lastPage, Integer total) {
}

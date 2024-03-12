package com.cookiedown.clienttest.dto;

import java.util.List;

public record WorldInfoResponse(String worldName, Integer worldId, List<ServerInfoResponse> servers) {
}

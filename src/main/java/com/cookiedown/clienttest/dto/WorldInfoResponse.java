package com.cookiedown.clienttest.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.util.ServerInfo;

import java.util.List;

@Getter
@Setter
public class WorldInfoResponse {
    private String worldName;
    private Integer worldId;
    private List<ServerInfoResponse> servers;
}

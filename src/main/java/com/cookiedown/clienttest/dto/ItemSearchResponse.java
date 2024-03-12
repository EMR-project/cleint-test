package com.cookiedown.clienttest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSearchResponse {
    private Integer itemId;
    private String itemName;
    private Integer serverId;
    private String serverName;
    private boolean world;
    private Integer enchant_level;
    private String grade;
    private String image;
    private Integer nonMinUnitPrice;
    private Integer avgUnitPrice;
}

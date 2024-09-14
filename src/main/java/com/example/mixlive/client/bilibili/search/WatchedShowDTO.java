package com.example.mixlive.client.bilibili.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class WatchedShowDTO {
    @JsonProperty("switch")
    private Boolean switchX;
    @JsonProperty("num")
    private Integer num;
    @JsonProperty("text_small")
    private String textSmall;
    @JsonProperty("text_large")
    private String textLarge;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("icon_location")
    private String iconLocation;
    @JsonProperty("icon_web")
    private String iconWeb;
}

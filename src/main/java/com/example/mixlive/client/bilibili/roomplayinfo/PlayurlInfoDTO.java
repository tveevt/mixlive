package com.example.mixlive.client.bilibili.roomplayinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PlayurlInfoDTO {
    @JsonProperty("conf_json")
    private String confJson;
    @JsonProperty("playurl")
    private PlayurlDTO playurl;
}

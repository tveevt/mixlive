package com.example.mixlive.client.bilibili.roomplayinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UrlInfoDTO {
    @JsonProperty("host")
    private String host;
    @JsonProperty("extra")
    private String extra;
    @JsonProperty("stream_ttl")
    private Integer streamTtl;
}

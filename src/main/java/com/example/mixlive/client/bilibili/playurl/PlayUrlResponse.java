package com.example.mixlive.client.bilibili.playurl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PlayUrlResponse {

    @JsonProperty("code")
    private Integer code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("ttl")
    private Integer ttl;
    @JsonProperty("data")
    private DataDTO data;
}

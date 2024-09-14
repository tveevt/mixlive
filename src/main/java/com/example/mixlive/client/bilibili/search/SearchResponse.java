package com.example.mixlive.client.bilibili.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SearchResponse {

    @JsonProperty("code")
    private Integer code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("ttl")
    private Integer ttl;
    @JsonProperty("data")
    private DataDTO data;
}

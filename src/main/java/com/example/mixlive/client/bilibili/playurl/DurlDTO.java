package com.example.mixlive.client.bilibili.playurl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DurlDTO {
    @JsonProperty("url")
    private String url;
    @JsonProperty("length")
    private Integer length;
    @JsonProperty("order")
    private Integer order;
    @JsonProperty("stream_type")
    private Integer streamType;
    @JsonProperty("p2p_type")
    private Integer p2pType;
}

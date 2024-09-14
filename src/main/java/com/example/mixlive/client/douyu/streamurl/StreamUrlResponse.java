package com.example.mixlive.client.douyu.streamurl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StreamUrlResponse {

    @JsonProperty("error")
    private Integer error;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("data")
    private DataDTO data;
}

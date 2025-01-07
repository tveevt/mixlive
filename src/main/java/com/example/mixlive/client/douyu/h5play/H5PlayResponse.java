package com.example.mixlive.client.douyu.h5play;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class H5PlayResponse {

    @JsonProperty("error")
    private Integer error;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("data")
    private DataDTO data;
}

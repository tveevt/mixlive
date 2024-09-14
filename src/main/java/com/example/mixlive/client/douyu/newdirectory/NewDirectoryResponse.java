package com.example.mixlive.client.douyu.newdirectory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class NewDirectoryResponse {

    @JsonProperty("error")
    private Integer error;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("data")
    private DataDTO data;
    @JsonProperty("redirectUrl")
    private Object redirectUrl;
}

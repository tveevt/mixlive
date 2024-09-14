package com.example.mixlive.client.douyu.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SearchShowResponse {

    @JsonProperty("data")
    private DataDTO data;
    @JsonProperty("error")
    private Integer error;
    @JsonProperty("msg")
    private String msg;
}

package com.example.mixlive.client.douyu.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AlgorithmDTO {
    @JsonProperty("st")
    private String st;
    @JsonProperty("rt")
    private String rt;
    @JsonProperty("_to_uid")
    private String toUid;
}

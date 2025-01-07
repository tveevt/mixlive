package com.example.mixlive.client.douyu.h5play;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CdnsWithNameDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("cdn")
    private String cdn;
    @JsonProperty("isH265")
    private Boolean isH265;
    @JsonProperty("re-weight")
    private Integer reweight;
}

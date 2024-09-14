package com.example.mixlive.client.douyu.mixlistv1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RsExtDTO {
    @JsonProperty("type")
    private String type;
    @JsonProperty("rs16")
    private String rs16;
    @JsonProperty("ratio")
    private Integer ratio;
}

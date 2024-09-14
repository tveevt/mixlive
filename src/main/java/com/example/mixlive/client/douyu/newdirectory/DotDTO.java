package com.example.mixlive.client.douyu.newdirectory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DotDTO {
    @JsonProperty("_rt_source")
    private String rtSource;
    @JsonProperty("_sub_rt")
    private String subRt;
    @JsonProperty("_rpos")
    private String rpos;
    @JsonProperty("_rt")
    private String rt;
    @JsonProperty("_rt_sub_source")
    private String rtSubSource;
}

package com.example.mixlive.client.douyu.newdirectory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ListDTO {
    @JsonProperty("cid2")
    private Integer cid2;
    @JsonProperty("cn2")
    private String cn2;
    @JsonProperty("stn2")
    private String stn2;
    @JsonProperty("url")
    private String url;
    @JsonProperty("cid1")
    private String cid1;
}

package com.example.mixlive.client.douyu.mixlistv1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DotV1DTO {
    @JsonProperty("_rec_t")
    private String recT;
    @JsonProperty("_rank")
    private String rank;
    @JsonProperty("_rpos")
    private String rpos;
    @JsonProperty("_rec_pos")
    private String recPos;
    @JsonProperty("_rt_s")
    private String rtS;
    @JsonProperty("_rt_ss")
    private String rtSs;
    @JsonProperty("_expose_cardid")
    private String exposeCardid;
}

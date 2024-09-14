package com.example.mixlive.client.bilibili.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DataDTO {
    @JsonProperty("seid")
    private String seid;
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("pagesize")
    private Integer pagesize;
    @JsonProperty("numResults")
    private Integer numResults;
    @JsonProperty("numPages")
    private Integer numPages;
    @JsonProperty("suggest_keyword")
    private String suggestKeyword;
    @JsonProperty("rqt_type")
    private String rqtType;
    @JsonProperty("cost_time")
    private CostTimeDTO costTime;
    @JsonProperty("exp_list")
    private ExpListDTO expList;
    @JsonProperty("egg_hit")
    private Integer eggHit;
    @JsonProperty("pageinfo")
    private PageinfoDTO pageinfo;
    @JsonProperty("result")
    private ResultDTO result;
    @JsonProperty("show_column")
    private Integer showColumn;
    @JsonProperty("in_black_key")
    private Integer inBlackKey;
    @JsonProperty("in_white_key")
    private Integer inWhiteKey;
}

package com.example.mixlive.client.douyu.newdirectory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BaseRecommendCategoryDTO {
    @JsonProperty("cate1Id")
    private Integer cate1Id;
    @JsonProperty("cate2Id")
    private Integer cate2Id;
    @JsonProperty("cate2Name")
    private String cate2Name;
    @JsonProperty("cate2Url")
    private String cate2Url;
    @JsonProperty("cate2Icon")
    private String cate2Icon;
    @JsonProperty("hot")
    private Object hot;
    @JsonProperty("isRec")
    private Integer isRec;
    @JsonProperty("isDisplay")
    private Integer isDisplay;
    @JsonProperty("isShowRec")
    private Object isShowRec;
}

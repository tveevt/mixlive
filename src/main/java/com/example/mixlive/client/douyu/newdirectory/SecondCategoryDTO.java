package com.example.mixlive.client.douyu.newdirectory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SecondCategoryDTO {
    @JsonProperty("cate2Name")
    private String cate2Name;
    @JsonProperty("cate2Icon")
    private String cate2Icon;
    @JsonProperty("cate2Url")
    private String cate2Url;
    @JsonProperty("customClassId")
    private Integer customClassId;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("dot")
    private DotDTO dot;
    @JsonProperty("hot")
    private Integer hot;
    @JsonProperty("cate1Id")
    private Integer cate1Id;
    @JsonProperty("cate2Id")
    private Integer cate2Id;
    @JsonProperty("isDisplay")
    private Integer isDisplay;
}

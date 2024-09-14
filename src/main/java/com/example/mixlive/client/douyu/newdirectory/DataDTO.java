package com.example.mixlive.client.douyu.newdirectory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class DataDTO {
    @JsonProperty("seoKeyword")
    private String seoKeyword;
    @JsonProperty("cate1Name")
    private String cate1Name;
    @JsonProperty("wcAbVer")
    private String wcAbVer;
    @JsonProperty("activeCate1Id")
    private Integer activeCate1Id;
    @JsonProperty("seoDescription")
    private String seoDescription;
    @JsonProperty("isShowFirstCategory")
    private Integer isShowFirstCategory;
    @JsonProperty("firstCategory")
    private List<FirstCategoryDTO> firstCategory;
    @JsonProperty("baseRecommendCategory")
    private List<BaseRecommendCategoryDTO> baseRecommendCategory;
    @JsonProperty("seoTitle")
    private String seoTitle;
    @JsonProperty("listType")
    private String listType;
    @JsonProperty("myCategory")
    private List<?> myCategory;
    @JsonProperty("leftNav")
    private LeftNavDTO leftNav;
    @JsonProperty("currentCate1Name")
    private String currentCate1Name;
    @JsonProperty("shortName")
    private String shortName;
    @JsonProperty("shortCategory")
    private List<?> shortCategory;
}

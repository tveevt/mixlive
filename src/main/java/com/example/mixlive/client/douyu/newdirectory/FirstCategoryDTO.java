package com.example.mixlive.client.douyu.newdirectory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class FirstCategoryDTO {
    @JsonProperty("cate1Name")
    private String cate1Name;
    @JsonProperty("secondCategory")
    private List<SecondCategoryDTO> secondCategory;
    @JsonProperty("customClassId")
    private Integer customClassId;
    @JsonProperty("isHideZero")
    private Integer isHideZero;
    @JsonProperty("shortName")
    private String shortName;
    @JsonProperty("cate1Id")
    private Integer cate1Id;
}

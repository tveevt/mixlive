package com.example.mixlive.client.bilibili.webarealist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ListDTO {
    @JsonProperty("id")
    private String id;
    @JsonProperty("parent_id")
    private String parentId;
    @JsonProperty("parent_name")
    private String parentName;
    @JsonProperty("old_area_id")
    private String oldAreaId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("pinyin")
    private String pinyin;
    @JsonProperty("act_id")
    private String actId;
    @JsonProperty("hot_status")
    private Integer hotStatus;
    @JsonProperty("pk_status")
    private String pkStatus;
    @JsonProperty("lock_status")
    private String lockStatus;
    @JsonProperty("pic")
    private String pic;
    @JsonProperty("area_type")
    private Integer areaType;
}

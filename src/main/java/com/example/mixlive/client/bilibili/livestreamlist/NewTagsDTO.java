package com.example.mixlive.client.bilibili.livestreamlist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class NewTagsDTO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("sort_type")
    private String sortType;
    @JsonProperty("type")
    private Integer type;
    @JsonProperty("sub")
    private List<?> sub;
    @JsonProperty("hero_list")
    private List<?> heroList;
    @JsonProperty("sort")
    private Integer sort;
}

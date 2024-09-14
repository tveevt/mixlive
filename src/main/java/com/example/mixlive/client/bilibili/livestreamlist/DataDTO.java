package com.example.mixlive.client.bilibili.livestreamlist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class DataDTO {
    @JsonProperty("banner")
    private List<?> banner;
    @JsonProperty("new_tags")
    private List<NewTagsDTO> newTags;
    @JsonProperty("list")
    private List<ListDTO> list;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("has_more")
    private Integer hasMore;
    @JsonProperty("vajra")
    private Object vajra;
}

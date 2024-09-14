package com.example.mixlive.client.bilibili.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LiveUserDTO {
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("numResults")
    private Integer numResults;
    @JsonProperty("pages")
    private Integer pages;
    @JsonProperty("numPages")
    private Integer numPages;
}

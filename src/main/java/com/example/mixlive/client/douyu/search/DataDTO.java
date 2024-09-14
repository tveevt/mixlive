package com.example.mixlive.client.douyu.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class DataDTO {
    @JsonProperty("pageSize")
    private Integer pageSize;
    @JsonProperty("relateShow")
    private List<RelateShowDTO> relateShow;
    @JsonProperty("total")
    private Integer total;
}

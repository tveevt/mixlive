package com.example.mixlive.client.douyu.newdirectory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class LeftNavDTO {
    @JsonProperty("link")
    private LinkDTO link;
    @JsonProperty("cateList")
    private List<CateListDTO> cateList;
}

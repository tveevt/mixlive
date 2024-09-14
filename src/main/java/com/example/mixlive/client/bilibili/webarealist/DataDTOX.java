package com.example.mixlive.client.bilibili.webarealist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class DataDTOX {
    @JsonProperty("data")
    private List<DataDTO> data;
    @JsonProperty("expid")
    private Integer expid;
}

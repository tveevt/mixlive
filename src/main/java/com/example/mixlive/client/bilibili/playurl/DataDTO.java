package com.example.mixlive.client.bilibili.playurl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class DataDTO {
    @JsonProperty("current_quality")
    private Integer currentQuality;
    @JsonProperty("accept_quality")
    private List<String> acceptQuality;
    @JsonProperty("current_qn")
    private Integer currentQn;
    @JsonProperty("quality_description")
    private List<QualityDescriptionDTO> qualityDescription;
    @JsonProperty("durl")
    private List<DurlDTO> durl;
}
